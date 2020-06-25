package ru.spliterash.vkchat;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAction;
import lombok.Getter;
import ru.spliterash.vkchat.obj.Launcher;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.vk.VkUtils;

@Getter
public class VkChat {
    @Getter
    private static VkChat instance;
    private final Launcher launcher;
    private final VkApiClient client = new VkApiClient(HttpTransportClient.getInstance());
    private GroupActor actor;
    private String peerId;
    private boolean enable = true;

    public static VkApiClient getClient() {
        return getInstance().client;
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
        client
                .groups()
                .setLongPollSettings(actor, actor.getGroupId())
                .apiVersion(client.getVersion())
                .messageNew(true)
                .execute();
        CallbackApiLongPoll poll = new CallbackApiLongPoll(client, actor, wait) {
            @Override
            public void messageNew(Integer groupId, Message message) {
                processMessage(message);
            }
        };
        while (enable) {
            poll.check();
        }
    }

    //TODO доработать
    private void processMessage(Message message) {
        MessageAction action = message.getAction();
        if (action != null) {
            switch (action.getType()) {
                case CHAT_INVITE_USER_BY_LINK:
                    break;
            }
            return;
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
