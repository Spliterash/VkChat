package ru.spliterash.vkchat;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import lombok.Getter;
import ru.spliterash.vkchat.launchers.Launcher;
import ru.spliterash.vkchat.vk.CallbackApiLongPoll;
import ru.spliterash.vkchat.vk.VkUtils;

@Getter
public class VkChat {
    @Getter
    private static VkChat instance;
    private final Launcher launcher;
    private final VkApiClient client = new VkApiClient(HttpTransportClient.getInstance());
    private final GroupActor actor;
    private final Integer peerId;
    private boolean enable = true;

    public static VkApiClient getClient() {
        return getInstance().client;
    }

    private VkChat(Launcher launcher) {
        this.launcher = launcher;
        String token = launcher.getVkConfig().getToken();
        if (token == null) {
            launcher.getLogger().warning("Set config");
            launcher.unload();
            throw new RuntimeException("Token is null");
        }
        int id;
        try {
            id = VkUtils.getMyId();
        } catch (Exception exception) {
            launcher.unload();
            throw new RuntimeException(exception);
        }
        actor = new GroupActor(id, token);
        peerId = launcher.getVkConfig().getPeer();
        launcher.runAsync(() -> {
            try {
                startLongPoll();
            } catch (ClientException | ApiException e) {
                e.printStackTrace();
                launcher.unload();
            }
        });
    }

    /**
     * Вызывать только асинхронно
     */
    private void startLongPoll() throws ClientException, ApiException {
        client
                .groups()
                .setLongPollSettings(actor, actor.getGroupId())
                .apiVersion(client.getVersion())
                .messageNew(true)
                .execute();
        CallbackApiLongPoll poll = new CallbackApiLongPoll(client, actor) {
            @Override
            public void messageNew(Integer groupId, Message message) {
                processMessage(message);
            }
        };
        while (enable) {
            poll.check();
        }
    }

    private void processMessage(Message message) {

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
