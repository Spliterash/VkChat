package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.allowMessagesFromGroup method
 */
public class MessagesAllowMessagesFromGroupQuery extends AbstractQueryBuilder<MessagesAllowMessagesFromGroupQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public MessagesAllowMessagesFromGroupQuery(VkApiClient client, UserActor actor, int groupId) {
        super(client, "messages.allowMessagesFromGroup", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
    }

    /**
     * Group ID.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesAllowMessagesFromGroupQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set key
     *
     * @param value value of "key" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesAllowMessagesFromGroupQuery key(String value) {
        return unsafeParam("key", value);
    }

    @Override
    protected MessagesAllowMessagesFromGroupQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
