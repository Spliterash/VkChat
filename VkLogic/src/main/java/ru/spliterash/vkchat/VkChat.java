package ru.spliterash.vkchat;

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
import lombok.Getter;
import ru.spliterash.vkchat.wrappers.Launcher;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class VkChat {
    @Getter
    private static VkChat instance;
    private final Launcher launcher;
    private final VkApiClient executor = new VkApiClient(HttpTransportClient.getInstance());
    private GroupActor actor;
    private String peerId;
    private boolean enable = true;
    private final Map<Integer, UserFull> savedUsers = new HashMap<>();

    public static VkApiClient getExecutor() {
        return getInstance().executor;
    }

    private VkChat(Launcher launcher) {
        this.launcher = launcher;
        launcher.runAsync(() -> {
            String token = launcher.getVkConfig().get("token");
            if (token == null) {
                launcher.getLogger().warning("Set config");
                launcher.unload();
                throw new RuntimeException("Token is null");
            }
            int id;
            try {
                id = VkUtils.getMyId(token);
            } catch (Exception exception) {
                launcher.unload();
                throw new RuntimeException(exception);
            }
            actor = new GroupActor(id, token);
            peerId = launcher.getVkConfig().get("peer");
            int wait = Integer.parseInt(launcher.getVkConfig().get("wait", "5000"));
            try {
                startLongPoll(wait);
            } catch (ClientException | ApiException e) {
                e.printStackTrace();
                launcher.unload();
            }
        });
    }

    /**
     * Вызывать только асинхронно
     */
    private void startLongPoll(int wait) throws ClientException, ApiException {
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
        loadUsers(ids);
        //Загрузили никнеймы, терь можно обработать сообщения TODO
    }

    private void loadUsers(Set<Integer> needLoad) throws ClientException, ApiException {
        //Удаляем тех кто загружен
        needLoad.removeAll(savedUsers.keySet());
        if (needLoad.size() > 0) {
            for (UserXtrCounters user : executor
                    .users()
                    .get(actor)
                    .userIds(needLoad.stream().map(Object::toString).collect(Collectors.toList()))
                    .fields(Fields.CITY, Fields.SEX, Fields.STATUS)
                    .execute()) {
                savedUsers.put(user.getId(), user);
            }
        }

    }

    public static void onEnable(Launcher launcher) {
        instance = new VkChat(launcher);
    }

    public static void onDisable() {
        if (instance != null) {
            instance.disable();
            instance = null;
        }
    }

    private void disable() {
        enable = false;
    }
}
