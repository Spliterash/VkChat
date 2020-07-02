package ru.spliterash.vkchat;

import com.j256.ormlite.dao.Dao;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.AccessLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.utils.PeekList;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.Launcher;

import java.io.File;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;
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

    private void setGlobalPeer(int id) {
        globalPeer = id;
        if (VkUtils.isConversation(id)) {
            ConversationDao dao = Database.getDao(ConversationModel.class);
            ConversationModel conversation;
            try {
                conversation = dao.queryForId(id);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
            if (conversation != null) {
                globalPeerUrl = conversation.getInviteLink();
            } else
                globalPeerUrl = null;
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
     * Обрабатываем сообщение, не зная какие есть ещё TODO
     */
    private void processMessages(Message message) {
        String text;
    }

    private void loadUsers(String... forceLoad) throws ClientException, ApiException {
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
        launcher.runTaskAsync(() -> instance = new VkChat(launcher));
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

    public UserFull getCachedUserById(int user) {
        return savedUsers.get(user);
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
        UserFull user = null;
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

    public boolean globalEnable() {
        return VkUtils.isConversation(globalPeer);
    }
}
