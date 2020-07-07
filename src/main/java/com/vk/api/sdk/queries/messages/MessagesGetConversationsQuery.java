package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.enums.MessagesFilter;
import com.vk.api.sdk.objects.messages.responses.GetConversationsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getConversations method
 */
public class MessagesGetConversationsQuery extends AbstractQueryBuilder<MessagesGetConversationsQuery, GetConversationsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesGetConversationsQuery(VkApiClient client, UserActor actor) {
        super(client, "messages.getConversations", GetConversationsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesGetConversationsQuery(VkApiClient client, GroupActor actor) {
        super(client, "messages.getConversations", GetConversationsResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
    }

    /**
     * Offset needed to return a specific subset of conversations.
     *
     * @param value value of "offset" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of conversations to return.
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Filter to apply: 'all' — all conversations, 'unread' — conversations with unread messages, 'important' — conversations, marked as important (only for community messages), 'unanswered' — conversations, marked as unanswered (only for community messages)
     *
     * @param value value of "filter" parameter. By default all.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery filter(MessagesFilter value) {
        return unsafeParam("filter", value);
    }

    /**
     * '1' — return extra information about users and communities
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * ID of the message from what to return dialogs.
     *
     * @param value value of "start message id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery startMessageId(Integer value) {
        return unsafeParam("start_message_id", value);
    }

    /**
     * Group ID (for group messages with group access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * fields
     * Profile and communities fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile and communities fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetConversationsQuery fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetConversationsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
