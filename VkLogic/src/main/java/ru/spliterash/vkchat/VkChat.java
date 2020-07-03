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
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.chat.ConversationSetup;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.ConversationInfo;
import ru.spliterash.vkchat.utils.PeekList;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.vk.MessageTree;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.Launcher;

import java.io.File;
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
    private final PeekList<GroupActor> actors;
    private final String commandPrefix;
    private boolean enable = true;
    @Getter(AccessLevel.NONE)
    private final Map<Integer, UserFull> savedUsers = new HashMap<>();
    @SuppressWarnings("FieldMayBeFinal")
    private int globalPeer;
    private String globalPeerUrl;
    private String globalPeerTitle;

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
    private VkChat(@NotNull Launcher launcher) throws ClientException, ApiException, SQLException {
        this.launcher = launcher;
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
        setGlobalPeer(config.getInt("global_peer"));
        commandPrefix = config.getString("command_prefix", "/");
        int wait = Integer.parseInt(config.getString("wait", "5000"));
        launcher.registerCommand("vk", new VkExecutor());
        if (VkUtils.isConversation(globalPeer))
            launcher.registerListener(new VkListener());
        try {
            startLongPoll(wait);
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
            launcher.unload();
        }
    }

    private void setGlobalPeer(int id) throws ClientException, ApiException, SQLException {
        globalPeer = id;
        if (VkUtils.isConversation(id)) {
            ConversationModel conversation = refreshConversationUsers(id);
            globalPeerUrl = conversation.getInviteLink();
            globalPeerTitle = conversation.getTitle();

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

    private void startLongPoll(int wait) throws ClientException, ApiException {
        GroupActor actor = getActor();
        executor
                .groups()
                .setLongPollSettings(actor, actor.getGroupId())
                .apiVersion(executor.getVersion())
                .messageNew(true)
                .execute();
        CallbackApiLongPoll poll = new CallbackApiLongPoll(executor, actor, wait) {

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
        //Сообщение с картинками, кидаем в процесс и забиваем
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
                        commandReply = String.join("\n", s);
                    launcher.runTaskAsync(() -> sendMessage(message.getPeerId(), commandReply));
                }));
            } else if (text.startsWith("verify ")) {
                String code = text.substring(7);
                verifyPeer(code, sender, message.getPeerId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            sendMessage(message.getPeerId(), ex.getLocalizedMessage());
        }
    }

    private void processAction(Message message, MessageAction action) throws ClientException, ApiException {
        switch (action.getType()) {
            case CHAT_INVITE_USER:
                sendActionMessage(message.getPeerId(), Lang.CONVERSATION_INVITE.toString(
                        "{inviter}", VkUtils.getPlayerToVk(message.getFromId()),
                        "{invited}", VkUtils.getPlayerToVk(action.getMemberId())
                ));
                break;
            case CHAT_INVITE_USER_BY_LINK:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_INVITE_BY_URL.toString("{user}",
                                VkUtils.getPlayerToVk(action.getMemberId()))
                );
                break;
            case CHAT_KICK_USER:
                sendActionMessage(
                        message.getPeerId(),
                        Lang.CONVERSATION_KICK.toString(
                                "{user_1}", VkUtils.getPlayerToVk(message.getFromId()),
                                "{user_2}", VkUtils.getPlayerToVk(action.getMemberId())
                        )
                );
                break;
        }
    }

    private void sendActionMessage(Integer peerId, String message) {

    }

    private void verifyPeer(String code, UserFull sender, Integer peerId) throws SQLException, ClientException, ApiException {
        ConversationSetup setup = ConversationSetup.getSetup(code);
        if (setup == null) {
            sendMessage(peerId, Lang.WRONG_CODE.toString());
            return;
        }
        setup.destroy();
        PlayerDao pDao = Database.getDao(PlayerModel.class);
        PlayerModel link = pDao.queryForVk(sender.getId());
        if (link == null) {
            sendMessage(peerId, Lang.NOT_LINK.toPlainText());
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
        ConversationModel model = new ConversationModel(peerId, link, VkUtils.getInviteLink(peerId));
        cDao.create(model);
        sendMessage(peerId, Lang.CONVERSATION_LINK_SUCCESS.toString());

    }

    public void sendMessageToPlayers(int peerId, Function<ConversationModel, BaseComponent[]> getter) throws ClientException, ApiException, SQLException {
        if (peerId == globalPeer) {
            for (AbstractPlayer player : launcher.getOnlinePlayers()) {
                if (player.hasPermission("vk.use")) {
                    player.sendMessage(getter.apply(null));
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
        ConversationInfo info = ConversationInfo.getInfo(conversationId);
        Set<Integer> conversationMembers = info.getMembers();
        Set<Integer> storeLinksIds = storeLinks.stream().map(a -> a.getPlayer().getVk()).collect(Collectors.toSet());
        int[] array = ArrayUtils.mergeTwoIntCollections(conversationMembers, storeLinksIds);
        List<PlayerModel> models = pDao.queryForVkMultiply(array);
        for (Integer conversationMember : conversationMembers) {
            PlayerModel currentPlayer = models
                    .stream()
                    .filter(m -> m.getVk() == conversationId)
                    .findFirst()
                    .orElse(null);
            if (currentPlayer == null)
                continue;
            //Если пользователь не сохранён на сервере как участник беседы, то добавляем его
            if (storeLinks.stream().noneMatch(storeUser -> storeUser.getPlayer().getVk() == conversationMember)) {
                PlayerConversationModel newModel = new PlayerConversationModel(currentPlayer, currentConversation);
                pcDao.createIfNotExists(newModel);
            }
        }
        for (PlayerConversationModel storeLink : storeLinks) {
            if (conversationMembers.stream().noneMatch(m -> m == storeLink.getPlayer().getVk())) {
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
                .fields(Fields.CITY, Fields.SEX, Fields.STATUS)
                .execute()) {
            savedUsers.put(user.getId(), user);
        }
    }

    private void loadWithChecks(Set<Integer> needLoad) throws ClientException, ApiException {
        //Удаляем тех кто загружен
        needLoad.removeAll(savedUsers.keySet());
        if (needLoad.size() > 0) {
            loadUsers(needLoad.stream().map(Object::toString).toArray(value -> new String[0]));
        }
    }


    public static void onEnable(Launcher launcher) {
        launcher.runTaskAsync(() -> {
            try {
                instance = new VkChat(launcher);
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
                .filter(u -> domain.toLowerCase().equals(u.getDomain()))
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
    public void sendMessage(int peer, String message) {
        try {
            executor
                    .messages()
                    .send(getActor())
                    .peerId(peer)
                    .message(message)
                    .execute();
        } catch (ApiException | ClientException e) {
            throw new RuntimeException(e);
        }
    }

}
