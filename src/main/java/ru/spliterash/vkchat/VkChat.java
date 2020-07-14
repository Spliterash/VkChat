package ru.spliterash.vkchat;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAction;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.AccessLevel;
import lombok.Getter;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.*;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.vk.MessageTree;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.Launcher;

import java.io.File;
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
    @SuppressWarnings("FieldMayBeFinal")
    private int globalPeer;
    private String globalPeerUrl;
    private ConversationModel globalConversation;

    public static VkApiClient getExecutor() {
        return getInstance().executor;
    }

    /**
     * Создаёт новый инстанц плагина
     * Вызывать ТОЛЬКО В ДРУГОМ ПОТОКЕ
     *
     * @param launcher Лаунчер, который запускает собсна, может быть спигот, банжа или Sponge
     *                 Можете вообще свой написать, если есть на что
     */
    private VkChat(@NotNull Launcher launcher) {
        this.launcher = launcher;
    }

    private void start() throws ClientException, ApiException, SQLException {
        Database.reload();
        AbstractConfig config = launcher.getVkConfig();
        File langFolder = new File(launcher.getDataFolder(), "lang");
        if (!langFolder.isDirectory()) {
            langFolder.mkdir();
        }
        String lang = config.getString("lang", "en");
        Lang.reload(langFolder, lang);
        List<String> tokens = config.getStringList("token");
        if (tokens.size() == 0) {
            launcher.getLogger().warning("Set config");
            launcher.unload();
            throw new RuntimeException("Token is null");
        }
        int id;
        try {
            id = VkUtils.getMyId(tokens.get(0));
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
        Integer gId = config.getInt("global_peer");
        if (gId != null)
            setGlobalPeer(gId);
        commandPrefix = config.getString("command_prefix", "/");

        launcher.registerCommand("vk", new VkExecutor());

        launcher.registerListener(new VkListener());
        try {
            startLongPoll();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
            launcher.unload();
        }
    }

    private void setGlobalPeer(int id) throws ClientException, ApiException, SQLException {
        globalPeer = id;
        if (VkUtils.isConversation(id)) {
            globalConversation = refreshConversationUsers(id);

        } else
            globalPeerUrl = null;
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


    private void processAction(Message message, MessageAction action) throws ClientException, ApiException, SQLException {
        switch (action.getType()) {
            case CHAT_INVITE_USER:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_INVITE.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{inviter}", new BaseComponent[]{VkUtils.getUserComponent(message.getFromId())})
                                .add("{invited}", new BaseComponent[]{VkUtils.getUserComponent(action.getMemberId())})
                                .getMap()


                );
                break;
            case CHAT_INVITE_USER_BY_LINK:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_INVITE_BY_URL.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{user}", new BaseComponent[]{VkUtils.getUserComponent(message.getFromId())})
                                .getMap());
                break;
            case CHAT_KICK_USER:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_KICK.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{user_1}", new BaseComponent[]{VkUtils.getUserComponent(message.getFromId())})
                                .add("{user_2}", new BaseComponent[]{VkUtils.getUserComponent(action.getMemberId())})
                                .getMap());
                break;
        }
    }

    private void sendActionMessage(Integer peerId, String messageStr, Map<String, BaseComponent[]> map) throws ClientException, ApiException, SQLException {
        String format = Lang.VK_TO_MINECRAFT_INFO_FORMAT.toString();
        sendMessageToPlayers(peerId, conversationModel -> {
            BaseComponent[] vk = VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle());
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
        AbstractPlayer p = setup.getPlayer();
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel anotherLink = dao.queryForVk(sender.getId());
        if (anotherLink != null) {
            sendMessage(peerId, Lang.VK_LINKED.toString("{minecraft}", VkUtils.getPlayerToVk(anotherLink)));
            return;
        }
        link = new PlayerModel(p.getUUID(), p.getName(), sender.getId());
        dao.create(link);
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

    private void verifyPeer(String code, UserFull sender, Integer peerId) throws SQLException, ClientException, ApiException {
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
        ConversationDao cDao = Database.getDao(ConversationModel.class);
        ConversationModel conversation = cDao.queryForId(peerId);
        if (conversation != null) {
            sendMessage(peerId, Lang.CONVERSATION_ALREADY_LINK.toString("{user}", VkUtils.getPlayerToVk(conversation.getOwner())));
            return;
        }
        if (!setup.getPlayer().getUUID().equals(link.getUuid())) {
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
        ConversationModel model = new ConversationModel(peerId, link, inviteLink);
        cDao.create(model);
        sendMessage(peerId, Lang.CONVERSATION_LINK_SUCCESS.toString());

    }

    public void sendMessageToPlayers(int peerId, Function<ConversationModel, BaseComponent[]> getter) throws ClientException, ApiException, SQLException {
        if (peerId == globalPeer) {
            for (AbstractPlayer player : launcher.getOnlinePlayers()) {
                if (player.hasPermission("vk.use")) {
                    player.sendMessage(getter.apply(globalConversation));
                }
            }
        } else {
            ConversationModel conversation = refreshConversationUsers(peerId);
            if (conversation != null) {
                PlayerConversationDao pcDao = Database.getDao(PlayerConversationModel.class);
                List<PlayerModel> list = pcDao.queryForConversation(peerId);
                BaseComponent[] msg = getter.apply(conversation);
                for (PlayerModel model : list) {
                    AbstractPlayer player = model.getOnlinePlayer();
                    if (player != null && player.hasPermission("vk.use"))
                        player.sendMessage(msg);
                }
            }

        }
    }

    private void sendUserTextMessage(Message message) throws ClientException, ApiException, SQLException {
        int peer = message.getPeerId();
        sendMessageToPlayers(
                peer,
                conversationModel -> new MessageTree(message, VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle())).getAll());

    }


    public ConversationModel refreshConversationUsers(int conversationId) throws ClientException, ApiException, SQLException {
        ConversationDao cDao = Database.getDao(ConversationModel.class);
        PlayerDao pDao = Database.getDao(PlayerModel.class);
        ConversationModel currentConversation = cDao.queryForId(conversationId);

        if (currentConversation == null) {
            sendMessage(conversationId, Lang.NOT_LINK_CONVERSATION.toString());
            return null;
        }
        PlayerConversationDao pcDao = Database.getDao(PlayerConversationModel.class);
        List<PlayerConversationModel> storeLinks = pcDao.findByConversation(conversationId);
        ConversationInfo info;
        try {
            info = ConversationInfo.getInfo(conversationId);
        } catch (ApiException ex) {
            cDao.delete(currentConversation);
            return null;
        }
        Set<Integer> conversationMembers = info.getMembers();
        Set<Integer> storeLinksIds = storeLinks.stream().map(a -> a.getPlayer().getVk()).collect(Collectors.toSet());
        int[] array = ArrayUtils.mergeTwoIntCollections(conversationMembers, storeLinksIds);
        List<PlayerModel> models = pDao.queryForVkMultiply(array);
        for (Integer conversationMember : conversationMembers) {
            PlayerModel currentPlayer = models
                    .stream()
                    .filter(m -> m.getVk() == conversationMember)
                    .findFirst()
                    .orElse(null);
            if (currentPlayer == null)
                continue;
            //Если пользователь не сохранён на сервере как участник беседы, то добавляем его
            if (storeLinks.stream().noneMatch(storeUser -> storeUser.getPlayer().getVk() == conversationMember)) {
                PlayerConversationModel newModel = new PlayerConversationModel(currentPlayer, currentConversation);
                pcDao.create(newModel);
            }
        }
        for (PlayerConversationModel storeLink : storeLinks) {
            if (conversationMembers.stream().noneMatch(m -> m == storeLink.getPlayer().getVk())) {
                ConversationModel conv = storeLink.getConversation();
                PlayerModel playerLink = storeLink.getPlayer();
                if (playerLink.getSelectedConversation() != null && playerLink.getSelectedConversation().getId() == conv.getId()) {
                    playerLink.setSelectedConversation(null);
                    pDao.update(playerLink);
                }
                pcDao.delete(storeLink);
            }
        }
        currentConversation.setTitle(info.getTitle());
        cDao.update(currentConversation);
        return currentConversation;
    }

    public void loadUsers(String... forceLoad) throws ClientException, ApiException {
        for (UserXtrCounters user : executor
                .users()
                .get(getActor())
                .userIds(forceLoad)
                .fields(Fields.CITY, Fields.SEX, Fields.DOMAIN, Fields.STATUS)
                .execute()) {
            savedUsers.put(user.getId(), user);
        }
    }

    private void loadWithChecks(Set<Integer> needLoad) throws ClientException, ApiException {
        //Удаляем тех кто загружен
        needLoad.removeAll(savedUsers.keySet());
        if (needLoad.size() > 0) {
            loadUsers(
                    needLoad
                            .stream()
                            .map(Object::toString)
                            .toArray(String[]::new)
            );
        }
    }


    public static void onEnable(Launcher launcher) {
        launcher.runTaskAsync(() -> {
            try {
                instance = new VkChat(launcher);
                instance.start();
            } catch (ClientException | ApiException | SQLException e) {
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

}
