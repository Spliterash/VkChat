package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.deleteAllRequests method
 */
public class FriendsDeleteAllRequestsQuery extends AbstractQueryBuilder<FriendsDeleteAllRequestsQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsDeleteAllRequestsQuery(VkApiClient client, UserActor actor) {
        super(client, "friends.deleteAllRequests", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    @Override
    protected FriendsDeleteAllRequestsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
