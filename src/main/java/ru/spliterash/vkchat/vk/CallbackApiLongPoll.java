package ru.spliterash.vkchat.vk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.exceptions.LongPollServerKeyExpiredException;
import com.vk.api.sdk.objects.callback.longpoll.responses.GetLongPollEventsResponse;
import com.vk.api.sdk.objects.callback.messages.CallbackMessage;
import com.vk.api.sdk.objects.groups.LongPollServer;
import com.vk.api.sdk.objects.messages.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class CallbackApiLongPoll {

    private int lastTimeStamp;
    private LongPollServer longPollServer;
    private static final Type messageNew = new TypeToken<CallbackMessage<Message>>() {
    }.getType();
    private final VkApiClient client;
    private final GroupActor groupActor;
    private final Integer waitTime;
    private final static Gson gson = new Gson();

    public CallbackApiLongPoll(VkApiClient client, GroupActor actor, int wait) throws ClientException, ApiException {
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
            lastTimeStamp = eventsResponse.getTs();
            List<Message> messages = new ArrayList<>(eventsResponse.getUpdates().size());
            for (JsonObject json : eventsResponse.getUpdates()) {
                String type = json.get("type").getAsString();
                if (type.equals("message_new")) {
                    CallbackMessage<Message> message = gson.fromJson(json, messageNew);
                    Message msg = message.getObject();
                    messages.add(msg);
                }
            }
            if (messages.size() > 0)
                processMessages(messages);
        } catch (LongPollServerKeyExpiredException e) {
            longPollServer = getLongPollServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected abstract void processMessages(List<Message> messages);

    private LongPollServer getLongPollServer() throws ClientException, ApiException {
        return client.groupsLongPoll().getLongPollServer(groupActor, groupActor.getGroupId()).execute();

    }
}
