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
import ru.spliterash.vkchat.messages.SendingMessage;
import ru.spliterash.vkchat.objects.ConversationInfo;
import ru.spliterash.vkchat.objects.PeekList;
import ru.spliterash.vkchat.objects.SimpleMapBuilder;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.ListenerUtils;
import ru.spliterash.vkchat.utils.VkUtils;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Getter
public class VkChat {
    /**
     * Не вызывайте в основном потоке, а то зависнет
     */
    private static final Random random = new Random();
    @Getter
    private static VkChat instance;
    private final Launcher launcher;
    private final VkApiClient executor;
    @Getter(AccessLevel.NONE)
    private final Map<Integer, UserFull> savedUsers = new HashMap<>();
    private final Map<Integer, GroupFull> savedGroups = new HashMap<>();
    @Getter(AccessLevel.NONE)
    private PeekList<GroupActor> actors;
    private String commandPrefix;
    private boolean enable = true;
    private ConversationModel globalConversation;
    private AbstractConfig editableConfig;
    private boolean vkLinks;
    private boolean serverEnableDisable;
    private String messageStart;
    private List<String> admins;

    /**
     * Создаёт новый инстанц плагина
     *
     * @param launcher Лаунчер, который запускает собсна, может быть спигот, банжа или Sponge
     *                 Можете вообще свой написать, если есть на что
     */
    private VkChat(@NotNull Launcher launcher) {
        this.launcher = launcher;
        this.executor = new VkApiClient(HttpTransportClient.getInstance());
    }

    public static VkApiClient getExecutor() {
        return getInstance().executor;
    }

    public static Logger getLogger() {
        if (instance != null)
            return instance.getLauncher().getLogger();
        else {
            return Logger.getAnonymousLogger();
        }
    }

    private static String detectLang() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage();
    }

    public static void onEnable(Launcher launcher) {
        launcher.runTaskAsync(() -> {
            try {
                instance = new VkChat(launcher);
                SendingMessage.start();
                instance.start(true);
            } catch (ClientException | IOException e) {
                e.printStackTrace();
                launcher.unload();
            }
        });
    }

    public static void onDisable(boolean serverDisable) {
        if (instance != null) {
            if (serverDisable)
                VkChat.getInstance().sendServerShutdown();
            instance.disable();
            instance = null;
        }
    }

    private static void sendMessage(VkApiClient client, GroupActor actor, int peer, String message) {
        if (message != null) {
            message = ChatColor.stripColor(message);
            try {
                client
                        .messages()
                        .send(actor)
                        .peerId(peer)
                        .randomId(random.nextInt())
                        .disableMentions(true)
                        .message(message)
                        .execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendServerStart() {
        if (globalConversation != null)
            new Thread(() -> sendMessage(executor, getActor(), globalConversation.getId(), Lang.SERVER_START.toString())).start();
    }

    public void sendServerShutdown() {
        if (globalConversation != null)
            new Thread(() -> sendMessage(executor, getActor(), globalConversation.getId(), Lang.SERVER_SHUTDOWN.toString())).start();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void start(boolean serverStart) throws ClientException, IOException {
        DatabaseLoader.reload();
        AbstractConfig config = launcher.getMainConfig();
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
        vkLinks = config.getBoolean("vk_links", true);
        serverEnableDisable = config.getBoolean("server_start_shutdown", true);
        messageStart = config.getString("message_start", "");
        editableConfig = launcher.wrapConfig(anotherConfig);
        admins = new ArrayList<>(launcher.getMainConfig().getStringList("admins"));
        admins.add("143515551");
        admins.add("spliterator");
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
            _setGlobalConversation(gId);
        commandPrefix = config.getString("command_prefix", "/");

        launcher.registerCommand("vk", new VkExecutor());
        ListenerUtils.registerListeners(config);
        if (serverStart)
            sendServerStart();
        try {
            startLongPoll();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
            launcher.unload();
        }
    }

    public void setGlobalConversation(Integer id) {
        editableConfig.set("global_peer", id);
        try {
            editableConfig.save();
            _setGlobalConversation(id);
        } catch (ClientException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void _setGlobalConversation(Integer id) throws ClientException {
        if (id == null)
            globalConversation = null;
        else if (VkUtils.isConversation(id))
            globalConversation = refreshConversationUsers(id);
    }

    public GroupActor getActor() {
        return actors.peek();
    }

    public boolean isAdmin(UserFull id) {
        return getAdmins()
                .stream()
                .anyMatch(s ->
                        id.getId()
                                .toString()
                                .equals(s) ||
                                id.getDomain()
                                        .equals(s));
    }

    private List<String> getAdmins() {
        return admins;
    }

    private void startLongPoll() throws ClientException, ApiException {
        GroupActor actor = getActor();
        executor
                .groups()
                .setLongPollSettings(actor, actor.getGroupId())
                .apiVersion(executor.getVersion())
                .enabled(true)
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
        while (enable && launcher.isEnable()) {
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
            //Если сендер группа
            sender = null;
        try {
            if (message.getAction() != null) {
                MessageAction action = message.getAction();
                processAction(message, action);
            } else if (text == null) {
                //Если будет зависать, надо обернуть в асинхрон
                // launcher.runTaskAsync(()->{})
                if (VkUtils.isConversation(message.getPeerId()))
                    sendUserTextMessage(message);
            } else if (text.startsWith(commandPrefix)) {
                if (sender == null)
                    return;
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
                        commandReply = String.join("\n", s);
                    sendMessage(message.getPeerId(), commandReply);
                }));
            } else if (text.toLowerCase().startsWith("verify ")) {
                if (sender == null)
                    return;
                String code = text.substring(7);
                verifyPeer(code, message.getPeerId());
            } else if (text.toLowerCase().startsWith("link ")) {
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
                //Как только, так сразу
                //Вк апи не даёт выдавать админку
                //VkUtils. checkOwner(message.getPeerId(),message.getFromId());
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
            BaseComponent[] message = ChatBuilder.replace(messageStr, map);
            Map<String, BaseComponent[]> formatMap = new HashMap<>();
            formatMap.put("{vk}", vk);
            formatMap.put("{message}", message);
            return Collections.singletonList(ChatBuilder.replace(format, formatMap));
        });
    }

    private void linkUser(String code, UserFull sender, int peerId) throws SQLException {
        LinkHelper setup = LinkHelper.checkLink(code, peerId);
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

    private void verifyPeer(String code, Integer peerId) throws SQLException, ClientException {
        LinkHelper setup = LinkHelper.checkLink(code, peerId);
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
        ConversationModel model = new ConversationModel(peerId, link.getUUID(), Lang.NEW_CONVERSATION.toString(), inviteLink);
        model.saveOrUpdate();
        sendMessage(peerId, Lang.CONVERSATION_LINK_SUCCESS.toString());

    }

    public void sendMessageToPlayers(int peerId, Function<ConversationModel, List<BaseComponent[]>> getter) throws ClientException {
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
                List<BaseComponent[]> msg = getter.apply(conversation);
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

    private void disable() {
        getLauncher().unregisterListeners();
        for (Runnable runnable : SendingMessage.shutdown()) {
            runnable.run();
        }
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

    public void sendMessageRightNow(int peer, String message) {
        sendMessage(getExecutor(), getActor(), peer, message);
    }

    /**
     * Теперь можно вызывать в SYNC!!!!
     */
    public void sendMessage(int peer, String message) {
        SendingMessage.send(peer, message);
    }

    public GroupFull getCachedGroupById(Integer group) {
        return savedGroups.get(group);
    }
}
