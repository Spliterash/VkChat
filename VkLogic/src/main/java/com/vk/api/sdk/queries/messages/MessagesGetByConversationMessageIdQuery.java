package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.GetByConversationMessageIdResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getByConversationMessageId method
 */
public class MessagesGetByConversationMessageIdQuery extends AbstractQueryBuilder<MessagesGetByConversationMessageIdQuery, GetByConversationMessageIdResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     * @param conversationMessageIds value of "conversation message ids" parameter.
     */
    public MessagesGetByConversationMessageIdQuery(VkApiClient client, UserActor actor, int peerId,
            Integer... conversationMessageIds) {
        super(client, "messages.getByConversationMessageId", GetByConversationMessageIdResponse.class);
        accessToken(actor.getAccessToken());
        peerId(peerId);
        conversationMessageIds(conversationMessageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     * @param conversationMessageIds value of "conversation message ids" parameter.
     */
    public MessagesGetByConversationMessageIdQuery(VkApiClient client, UserActor actor, int peerId,
            List<Integer> conversationMessageIds) {
        super(client, "messages.getByConversationMessageId", GetByConversationMessageIdResponse.class);
        accessToken(actor.getAccessToken());
        peerId(peerId);
        conversationMessageIds(conversationMessageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     * @param conversationMessageIds value of "conversation message ids" parameter.
     */
    public MessagesGetByConversationMessageIdQuery(VkApiClient client, GroupActor actor, int peerId,
            Integer... conversationMessageIds) {
        super(client, "messages.getByConversationMessageId", GetByConversationMessageIdResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        peerId(peerId);
        conversationMessageIds(conversationMessageIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     * @param conversationMessageIds value of "conversation message ids" parameter.
     */
    public MessagesGetByConversationMessageIdQuery(VkApiClient client, GroupActor actor, int peerId,
            List<Integer> conversationMessageIds) {
        super(client, "messages.getByConversationMessageId", GetByConversationMessageIdResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        peerId(peerId);
        conversationMessageIds(conversationMessageIds);
    }

    /**
     * Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. "
     *
     * @param value value of "peer id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetByConversationMessageIdQuery peerId(int value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * Information whether the response should be extended
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByConversationMessageIdQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Group ID (for group messages with group access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByConversationMessageIdQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * conversation_message_ids
     * Conversation message IDs.
     *
     * @param value value of "conversation message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetByConversationMessageIdQuery conversationMessageIds(Integer... value) {
        return unsafeParam("conversation_message_ids", value);
    }

    /**
     * Conversation message IDs.
     *
     * @param value value of "conversation message ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetByConversationMessageIdQuery conversationMessageIds(List<Integer> value) {
        return unsafeParam("conversation_message_ids", value);
    }

    /**
     * fields
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByConversationMessageIdQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetByConversationMessageIdQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetByConversationMessageIdQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("peer_id", "conversation_message_ids", "access_token");
    }
}
