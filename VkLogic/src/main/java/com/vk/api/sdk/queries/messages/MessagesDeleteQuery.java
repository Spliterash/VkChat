package com.vk.api.sdk.queries.messages;

import com.google.gson.reflect.TypeToken;
import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Query for Messages.delete method
 */
public class MessagesDeleteQuery extends AbstractQueryBuilder<MessagesDeleteQuery, Map<Integer, String>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesDeleteQuery(VkApiClient client, UserActor actor) {
        super(client, "messages.delete", new TypeToken< Map< java.lang.Integer,com.vk.api.sdk.objects.base.BoolInt> >(){}.getType());
        accessToken(actor.getAccessToken());
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesDeleteQuery(VkApiClient client, GroupActor actor) {
        super(client, "messages.delete", new TypeToken< Map< java.lang.Integer,com.vk.api.sdk.objects.base.BoolInt> >(){}.getType());
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
    }

    /**
     * '1' — to mark message as spam.
     *
     * @param value value of "spam" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesDeleteQuery spam(Boolean value) {
        return unsafeParam("spam", value);
    }

    /**
     * Group ID (for group messages with user access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesDeleteQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * '1' — delete message for for all.
     *
     * @param value value of "delete for all" parameter. By default false.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesDeleteQuery deleteForAll(Boolean value) {
        return unsafeParam("delete_for_all", value);
    }

    /**
     * message_ids
     * Message IDs.
     *
     * @param value value of "message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesDeleteQuery messageIds(Integer... value) {
        return unsafeParam("message_ids", value);
    }

    /**
     * Message IDs.
     *
     * @param value value of "message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesDeleteQuery messageIds(List<Integer> value) {
        return unsafeParam("message_ids", value);
    }

    @Override
    protected MessagesDeleteQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
