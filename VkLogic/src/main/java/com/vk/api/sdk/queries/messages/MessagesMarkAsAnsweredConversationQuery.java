package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.markAsAnsweredConversation method
 */
public class MessagesMarkAsAnsweredConversationQuery extends AbstractQueryBuilder<MessagesMarkAsAnsweredConversationQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     */
    public MessagesMarkAsAnsweredConversationQuery(VkApiClient client, UserActor actor,
            int peerId) {
        super(client, "messages.markAsAnsweredConversation", OkResponse.class);
        accessToken(actor.getAccessToken());
        peerId(peerId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     */
    public MessagesMarkAsAnsweredConversationQuery(VkApiClient client, GroupActor actor,
            int peerId) {
        super(client, "messages.markAsAnsweredConversation", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        peerId(peerId);
    }

    /**
     * ID of conversation to mark as important.
     *
     * @param value value of "peer id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesMarkAsAnsweredConversationQuery peerId(int value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * '1' — to mark as answered, '0' — to remove the mark
     *
     * @param value value of "answered" parameter. By default 1.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesMarkAsAnsweredConversationQuery answered(Boolean value) {
        return unsafeParam("answered", value);
    }

    /**
     * Group ID (for group messages with group access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesMarkAsAnsweredConversationQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected MessagesMarkAsAnsweredConversationQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("peer_id", "access_token");
    }
}
