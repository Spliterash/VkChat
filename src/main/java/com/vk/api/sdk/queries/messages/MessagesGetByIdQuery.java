package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.GetByIdResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getById method
 */
public class MessagesGetByIdQuery extends AbstractQueryBuilder<MessagesGetByIdQuery, GetByIdResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param messageIds value of "message ids" parameter.
     */
    public MessagesGetByIdQuery(VkApiClient client, UserActor actor, Integer... messageIds) {
        super(client, "messages.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        messageIds(messageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param messageIds value of "message ids" parameter.
     */
    public MessagesGetByIdQuery(VkApiClient client, UserActor actor, List<Integer> messageIds) {
        super(client, "messages.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        messageIds(messageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param messageIds value of "message ids" parameter.
     */
    public MessagesGetByIdQuery(VkApiClient client, GroupActor actor, Integer... messageIds) {
        super(client, "messages.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        messageIds(messageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param messageIds value of "message ids" parameter.
     */
    public MessagesGetByIdQuery(VkApiClient client, GroupActor actor, List<Integer> messageIds) {
        super(client, "messages.getById", GetByIdResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        messageIds(messageIds);
    }

    /**
     * Number of characters after which to truncate a previewed message. To preview the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated by words."
     *
     * @param value value of "preview length" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByIdQuery previewLength(Integer value) {
        return unsafeParam("preview_length", value);
    }

    /**
     * Information whether the response should be extended
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByIdQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Group ID (for group messages with group access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByIdQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * message_ids
     * Message IDs.
     *
     * @param value value of "message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetByIdQuery messageIds(Integer... value) {
        return unsafeParam("message_ids", value);
    }

    /**
     * Message IDs.
     *
     * @param value value of "message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetByIdQuery messageIds(List<Integer> value) {
        return unsafeParam("message_ids", value);
    }

    /**
     * fields
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByIdQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByIdQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetByIdQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("message_ids", "access_token");
    }
}
