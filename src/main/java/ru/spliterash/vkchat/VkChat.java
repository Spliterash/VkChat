package ru.spliterash.vkchat;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAction;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.utils.*;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.vk.MessageTree;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.Launcher;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class VkChat {
    @Getter
    private static VkChat instance;
    private final Launcher launcher;
    private final VkApiClient executor = new VkApiClient(HttpTransportClient.getInstance());
    @Getter(AccessLevel.NONE)
    private PeekList<GroupActor> actors;
    private String commandPrefix;
    private boolean enable = true;
    @Getter(AccessLevel.NONE)
    private final Map<Integer, UserFull> savedUsers = new HashMap<>();
    private final Map<Integer, GroupFull> savedGroups = new HashMap<>();
    private ConversationModel globalConversation;
    private AbstractConfig editableConfig;

    public static VkApiClient getExecutor() {
        return getInstance().executor;
    }

    /**
     * Создаёт новый инстанц плагина
     *
     * @param launcher Лаунчер, который запускает собсна, может быть спигот, банжа или Sponge
     *                 Можете вообще свой написать, если есть на что
     */
    private VkChat(@NotNull Launcher launcher) {
        this.launcher = launcher;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void start() throws ClientException, IOException {
        DatabaseLoader.reload();
        AbstractConfig config = launcher.getVkConfig();
        File langFolder = new File(launcher.getDataFolder(), "lang");
        if (!langFolder.isDirectory()) {
            langFolder.mkdir();
        }
        File anotherConfig = new File(launcher.getDataFolder(), "another_config.yml");
        String lang;
        if (!anotherConfig.isFile()) {
            try {
                anotherConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        editableConfig = launcher.wrapConfig(anotherConfig);
        lang = editableConfig.getString("lang");
        if (lang == null) {
            lang = detectLang();
            editableConfig.set("lang", lang);
            editableConfig.save();
        }
        Lang.reload(langFolder, lang);
        List<String> tokens = config.getStringList("token");
        if (tokens.size() == 0) {
            launcher.getLogger().warning("Set token");
            launcher.unload();
            return;
        }
        String token = tokens.get(0);
        if (token.equals("Place group token here|Сюда писать токен группы")) {
            launcher.getLogger().warning("Set token in plugin config");
            launcher.unload();
            return;
        }
        int id;
        try {
            id = VkUtils.getMyId(token);
        } catch (Exception exception) {
            launcher.unload();
            throw new RuntimeException(exception);
        }
        actors = new PeekList<>(
                tokens
                        .stream()
                        .map(t -> new GroupActor(id, t))
                        .collect(Collectors.toList())
        );
        Integer gId = editableConfig.getInt("global_peer");
        if (gId != null)
            _setGlobalPeer(gId);
        commandPrefix = config.getString("command_prefix", "/");

        launcher.registerCommand("vk", new VkExecutor());
        ListenerUtils.registerListeners(config);
        try {
            startLongPoll();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
            launcher.unload();
        }
    }

    private static String detectLang() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage();
    }

    public void setGlobalPeer(int id) {
        editableConfig.set("global_peer", id);
        try {
            editableConfig.save();
            _setGlobalPeer(id);
        } catch (ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void _setGlobalPeer(int id) throws ClientException {
        if (VkUtils.isConversation(id))
            globalConversation = refreshConversationUsers(id);
    }

    public GroupActor getActor() {
        return actors.peek();
    }

    public boolean isAdmin(UserFull id) {
        return getAdmins()
                .stream()
                .anyMatch(s -> id.getId().toString().equals(s) || id.getDomain().equals(s));
    }

    private List<String> getAdmins() {
        return launcher.getVkConfig().getStringList("admins");
    }

    private void startLongPoll() throws ClientException, ApiException {
        GroupActor actor = getActor();
        executor
                .groups()
                .setLongPollSettings(actor, actor.getGroupId())
                .apiVersion(executor.getVersion())
                .messageNew(true)
                .execute();
        CallbackApiLongPoll poll = new CallbackApiLongPoll(executor, actor, 25) {

            @Override
            protected void processMessages(List<Message> messages) {
                try {
                    VkChat.this.processMessages(messages);
                } catch (ClientException | ApiException e) {
                    e.printStackTrace();
                }
            }
        };
        while (enable) {
            poll.check();
        }
    }

    private void processMessages(List<Message> messages) throws ClientException, ApiException {
        Set<Integer> ids = new HashSet<>(messages.size());
        for (Message message : messages) {
            ids.add(message.getFromId());
            message.getFwdMessages().forEach(m -> VkUtils.scanMessageIds(ids, m));
            ForeignMessage reply = message.getReplyMessage();
            if (reply != null)
                VkUtils.scanMessageIds(ids, reply);
        }
        loadWithChecks(ids);
        //Загрузили никнеймы, терь можно обработать сообщения
        for (Message message : messages) {
            processMessages(message);
        }
    }

    /**
     * Обрабатываем сообщение
     */
    private void processMessages(Message message) {
        String text = message.getText();
        final UserFull sender;
        if (message.getFromId() != null)
            sender = getCachedUserById(message.getFromId());
        else
            sender = null;
        try {
            if (message.getAction() != null) {
                MessageAction action = message.getAction();
                processAction(message, action);
            } else if (sender == null) {
                throw new Exception("Null sender, how");
            } else if (text == null) {
                //FIXME Если будет зависать, надо будет обернуть в асинхрон
                // launcher.runTaskAsync(()->{})
                if (VkUtils.isConversation(message.getPeerId()))
                    sendUserTextMessage(message);
            } else if (text.startsWith(commandPrefix)) {
                if (!isAdmin(sender)) {
                    sendMessage(message.getPeerId(), Lang.NO_PEX.toPlainText());
                    return;
                }
                String command = text.substring(commandPrefix.length());
                launcher.runTask(() -> launcher.executeCommand("vkSender(id" + sender.getId() + ")", command, s -> {
                    String commandReply;
                    if (s == null || s.length == 0)
                        commandReply = Lang.CONSOLE_COMMAND.toString();
                    else
                        commandReply = ChatColor.stripColor(String.join("\n", s));
                    launcher.runTaskAsync(() -> sendMessage(message.getPeerId(), commandReply));
                }));
            } else if (text.startsWith("verify ")) {
                String code = text.substring(7);
                verifyPeer(code, sender, message.getPeerId());
            } else if (text.startsWith("link ")) {
                String code = text.substring(5);
                linkUser(code, sender, message.getPeerId());
            } else if (VkUtils.isConversation(message.getPeerId())) {
                sendUserTextMessage(message);
            }
        } catch (Exception ex) {
            StringWriter strWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(strWriter);
            ex.printStackTrace(writer);
            sendMessage(message.getPeerId(), strWriter.toString());
        }
    }


    private void processAction(Message message, MessageAction action) throws ClientException {
        switch (action.getType()) {
            case CHAT_INVITE_USER:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_INVITE.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{inviter}", new BaseComponent[]{VkUtils.getSenderComponent(message.getFromId())})
                                .add("{invited}", new BaseComponent[]{VkUtils.getSenderComponent(action.getMemberId())})
                                .getMap()


                );
                break;
            case CHAT_INVITE_USER_BY_LINK:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_INVITE_BY_URL.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{user}", new BaseComponent[]{VkUtils.getSenderComponent(message.getFromId())})
                                .getMap());
                break;
            case CHAT_KICK_USER:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_KICK.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{user_1}", new BaseComponent[]{VkUtils.getSenderComponent(message.getFromId())})
                                .add("{user_2}", new BaseComponent[]{VkUtils.getSenderComponent(action.getMemberId())})
                                .getMap());
                break;
        }
    }

    private void sendActionMessage(Integer peerId, String messageStr, Map<String, BaseComponent[]> map) throws ClientException {
        String format = Lang.VK_TO_MINECRAFT_INFO_FORMAT.toString();
        sendMessageToPlayers(peerId, conversationModel -> {
            BaseComponent[] vk = new BaseComponent[]{VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle())};
            BaseComponent[] message = ChatBuilder.compile(messageStr, map);
            Map<String, BaseComponent[]> formatMap = new HashMap<>();
            formatMap.put("{vk}", vk);
            formatMap.put("{message}", message);
            return ChatBuilder.compile(format, formatMap);
        });
    }


    private void linkUser(String code, UserFull sender, int peerId) throws SQLException {
        LinkHelper setup = checkLink(code, peerId);
        if (setup == null)
            return;
        PlayerModel link = setup.getPlayerModel();
        if (link != null) {
            sendMessage(peerId, Lang.ALREADY_LINK.toPlainText("{user}", VkUtils.getPlayerToVk(link)));
            return;
        }
        AbstractBase base = DatabaseLoader.getBase();
        AbstractPlayer p = setup.getPlayer();
        PlayerModel anotherLink = base.getPlayerByVk(sender.getId());
        if (anotherLink != null) {
            sendMessage(peerId, Lang.VK_LINKED.toString("{minecraft}", VkUtils.getPlayerToVk(anotherLink)));
            return;
        }
        link = new PlayerModel(p.getUUID(), p.getName(), sender.getId(), null);
        link.saveOrUpdate();
        sendMessage(peerId, Lang.USER_LINK_SUCCESS.toString());
    }

    private LinkHelper checkLink(String code, int peerId) {
        LinkHelper setup = LinkHelper.getSetup(code);
        if (setup == null) {
            sendMessage(peerId, Lang.WRONG_CODE.toString());
            return null;
        }
        setup.destroy();
        return setup;
    }

    private void verifyPeer(String code, UserFull sender, Integer peerId) throws SQLException, ClientException {
        LinkHelper setup = checkLink(code, sender.getId());
        if (setup == null)
            return;
        PlayerModel link = setup.getPlayerModel();
        if (link == null) {
            sendMessage(peerId, Lang.NOT_LINK.toPlainText());
            return;
        }
        if (!VkUtils.isConversation(peerId)) {
            sendMessage(peerId, Lang.NOT_CONVERSATION.toString());
            return;
        }
        AbstractBase base = DatabaseLoader.getBase();
        ConversationModel conversation = base.getConversationById(peerId);
        if (conversation != null) {
            sendMessage(peerId, Lang.CONVERSATION_ALREADY_LINK.toString("{user}", VkUtils.getPlayerToVk(conversation.getOwnerModel())));
            return;
        }
        if (!setup.getPlayer().getUUID().equals(link.getUUID())) {
            sendMessage(peerId, Lang.YOU_NOT_INITIALIZE_LINK.toString());
            return;
        }
        String inviteLink = null;
        try {
            inviteLink = VkUtils.getInviteLink(peerId);
        } catch (ApiException ex) {
            if (ex.getCode() == 919 || ex.getCode() == 931) {
                sendMessage(peerId, Lang.LINK_FAIL.toString());
                return;
            }
        }
        ConversationModel model = new ConversationModel(peerId, link.getUUID(), "[ДАННЫЕ УДАЛЕНЫ]", inviteLink);
        model.saveOrUpdate();
        sendMessage(peerId, Lang.CONVERSATION_LINK_SUCCESS.toString());

    }

    public void sendMessageToPlayers(int peerId, Function<ConversationModel, BaseComponent[]> getter) throws ClientException {
        if (globalConversation != null && globalConversation.getId() == peerId) {
            for (AbstractPlayer player : launcher.getOnlinePlayers()) {
                if (player.hasPermission("vk.use")) {
                    player.sendMessage(getter.apply(globalConversation));
                }
            }
        } else {
            ConversationModel conversation = refreshConversationUsers(peerId);
            if (conversation != null) {
                List<PlayerModel> list = DatabaseLoader.getBase().getConversationMembers(peerId);
                BaseComponent[] msg = getter.apply(conversation);
                for (PlayerModel model : list) {
                    AbstractPlayer player = model.getOnlinePlayer();
                    if (player != null && player.hasPermission("vk.use"))
                        player.sendMessage(msg);
                }
            }

        }
    }

    private void sendUserTextMessage(Message message) throws ClientException {
        int peer = message.getPeerId();
        sendMessageToPlayers(
                peer,
                conversationModel -> new MessageTree(message, VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle())).getAll());

    }


    public ConversationModel refreshConversationUsers(int conversationId) throws ClientException {
        AbstractBase base = DatabaseLoader.getBase();
        ConversationModel currentConversation = base.getConversationById(conversationId);

        if (currentConversation == null) {
            sendMessage(conversationId, Lang.NOT_LINK_CONVERSATION.toString());
            return null;
        }
        //Участники которые находятся в беседе в нашей БД
        List<PlayerModel> storeLinks = base.getConversationMembers(conversationId);
        ConversationInfo info;
        try {
            info = ConversationInfo.getInfo(conversationId);
        } catch (ApiException ex) {
            currentConversation.delete();
            return null;
        }
        //Участники которые находятся в беседе на стороне вк
        Set<Integer> conversationMembers = info.getMembers();
        //Идшники наших участников
        Set<Integer> storeLinksIds = storeLinks.stream().map(PlayerModel::getVk).collect(Collectors.toSet());
        Integer[] array = ArrayUtils.mergeTwoIntCollections(Integer.class, conversationMembers, storeLinksIds);
        List<PlayerModel> models = base.getPlayerByVk(array);
        for (Integer conversationMember : conversationMembers) {
            PlayerModel currentPlayer = models
                    .stream()
                    .filter(m -> m.getVk() == conversationMember)
                    .findFirst()
                    .orElse(null);
            if (currentPlayer == null)
                continue;
            //Если пользователь не сохранён на сервере как участник беседы, то добавляем его
            if (storeLinks.stream().noneMatch(storeUser -> storeUser.getVk() == conversationMember)) {
                base.addMember(currentPlayer, currentConversation);
            }
        }
        for (PlayerModel player : storeLinks) {
            if (conversationMembers.stream().noneMatch(m -> m == player.getVk())) {
                if (player.getSelectedConversation() != null && player.getSelectedConversation() == currentConversation.getId()) {
                    player.setSelectedConversation(null);
                    player.saveOrUpdate();
                }
                base.removeMember(player, currentConversation);
            }
        }
        currentConversation.setTitle(info.getTitle());
        currentConversation.saveOrUpdate();
        return currentConversation;
    }

    public void loadUsersAndBots(Set<Integer> forceLoad) throws ClientException, ApiException {
        Set<Integer> users = new HashSet<>();
        Set<Integer> groups = new HashSet<>();
        for (Integer id : forceLoad) {
            if (VkUtils.isGroup(id))
                groups.add(id);
            else
                users.add(id);
        }
        if (users.size() > 0)
            loadUsers(users
                    .stream()
                    .map(Object::toString)
                    .toArray(String[]::new));
        if (groups.size() > 0)
            loadGroups(users
                    .stream()
                    .map(Object::toString)
                    .toArray(String[]::new));
    }

    private void loadGroups(String... groups) throws ClientException, ApiException {
        for (GroupFull groupFull : executor
                .groups()
                .getById(getActor())
                .groupIds(groups)
                .fields(com.vk.api.sdk.objects.groups.Fields.DESCRIPTION)
                .execute()) {
            savedGroups.put(groupFull.getId() * -1, groupFull);
        }
    }

    public void loadUsers(String... forceLoad) throws ClientException, ApiException {
        for (UserXtrCounters user : executor
                .users()
                .get(getActor())
                .userIds(forceLoad)
                .fields(Fields.CITY, Fields.SEX, Fields.DOMAIN, Fields.STATUS, Fields.BDATE)
                .execute()) {
            savedUsers.put(user.getId(), user);
        }
    }

    private void loadWithChecks(Set<Integer> needLoad) throws ClientException, ApiException {
        //Удаляем тех кто загружен
        needLoad.removeAll(savedUsers.keySet());
        needLoad.removeAll(savedGroups.keySet());
        if (needLoad.size() > 0) {
            loadUsersAndBots(needLoad);
        }
    }


    public static void onEnable(Launcher launcher) {
        launcher.runTaskAsync(() -> {
            try {
                instance = new VkChat(launcher);
                instance.start();
            } catch (ClientException | IOException e) {
                e.printStackTrace();
                launcher.unload();
            }
        });
    }

    public static void onDisable() {
        if (instance != null) {
            instance.disable();
            instance = null;
        }
    }

    private void disable() {
        getLauncher().unregisterListeners();
        enable = false;
    }

    public UserFull getCachedUserById(int userId, boolean getIfNot) throws ClientException, ApiException {
        UserFull user = savedUsers.get(userId);
        if (user == null && getIfNot) {
            loadUsers(String.valueOf(userId));
            user = savedUsers.get(userId);
        }
        return user;

    }

    public UserFull getCachedUserById(int user) {
        try {
            return getCachedUserById(user, false);
        } catch (ClientException | ApiException e) {
            throw new RuntimeException(e);
        }
    }

    public UserFull getCachedUserByDomain(String domain) {
        return savedUsers
                .values()
                .stream()
                .filter(u -> domain.toLowerCase().equals(u.getDomain()) || u.getId().toString().equals(domain))
                .findFirst()
                .orElse(null);
    }

    public void userAction(String id, Consumer<UserFull> consumer) {
        userAction(id, consumer, false);
    }

    public void userAction(String id, Consumer<UserFull> consumer, boolean onlySync) {
        UserFull user;
        try {
            user = getCachedUserById(Integer.parseInt(id));
        } catch (Exception ex) {
            user = getCachedUserByDomain(id);
        }
        if (user == null) {
            getLauncher().runTaskAsync(() -> {
                try {
                    loadUsers(id);
                } catch (ClientException | ApiException e) {
                    throw new RuntimeException(e);
                }
                UserFull serverUser = getCachedUserByDomain(id);
                if (onlySync)
                    getLauncher().runTask(() -> consumer.accept(serverUser));
                else
                    consumer.accept(serverUser);
            });
        } else if (launcher.isPrimaryThread()) {
            consumer.accept(user);
        } else {
            UserFull finalUser = user;
            getLauncher().runTask(() -> consumer.accept(finalUser));
        }
    }


    /**
     * Не вызывайте в основном потоке, а то зависнет
     */
    private static final Random random = new Random();

    public void sendMessage(int peer, String message) {
        try {
            executor
                    .messages()
                    .send(getActor())
                    .peerId(peer)
                    .randomId(random.nextInt())
                    .message(message)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
    }

    public GroupFull getCachedGroupById(Integer group) {
        return savedGroups.get(group);
    }
}
