package ru.spliterash.vkchat.vk;

import com.google.gson.JsonObject;
import com.vk.api.sdk.callback.CallbackApi;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.exceptions.LongPollServerKeyExpiredException;
import com.vk.api.sdk.objects.callback.longpoll.responses.GetLongPollEventsResponse;
import com.vk.api.sdk.objects.groups.LongPollServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.spliterash.vkchat.VkChat;

public abstract class CallbackApiLongPoll extends CallbackApi {

    private static final Logger LOG = LogManager.getLogger(com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll.class);

    private int lastTimeStamp;
    private LongPollServer longPollServer;

    private final VkApiClient client;
    private final GroupActor groupActor;
    private final Integer waitTime;


    public CallbackApiLongPoll(VkApiClient client, GroupActor actor,int wait) throws ClientException, ApiException {
        this.client = client;
        this.groupActor = actor;
        longPollServer = getLongPollServer();
        lastTimeStamp = Integer.parseInt(longPollServer.getTs());
        waitTime = wait;
    }


    public void check() throws ClientException, ApiException {

        try {
            GetLongPollEventsResponse eventsResponse = client
                    .longPoll()
                    .getEvents(
                            longPollServer.getServer(),
                            longPollServer.getKey(),
                            lastTimeStamp)
                    .waitTime(waitTime)
                    .execute();
            for (JsonObject jsonObject : eventsResponse.getUpdates()) {
                parse(jsonObject);
            }
            lastTimeStamp = eventsResponse.getTs();
        } catch (LongPollServerKeyExpiredException e) {
            longPollServer = getLongPollServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private LongPollServer getLongPollServer() throws ClientException, ApiException {
        return client.groupsLongPoll().getLongPollServer(groupActor, groupActor.getGroupId()).execute();

    }
}
