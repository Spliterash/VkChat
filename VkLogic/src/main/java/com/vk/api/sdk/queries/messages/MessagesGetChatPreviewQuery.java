package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.GetChatPreviewResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getChatPreview method
 */
public class MessagesGetChatPreviewQuery extends AbstractQueryBuilder<MessagesGetChatPreviewQuery, GetChatPreviewResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesGetChatPreviewQuery(VkApiClient client, UserActor actor) {
        super(client, "messages.getChatPreview", GetChatPreviewResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Set peer id
     *
     * @param value value of "peer id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetChatPreviewQuery peerId(Integer value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * Invitation link.
     *
     * @param value value of "link" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetChatPreviewQuery link(String value) {
        return unsafeParam("link", value);
    }

    /**
     * fields
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetChatPreviewQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetChatPreviewQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetChatPreviewQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
