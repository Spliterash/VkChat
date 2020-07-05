package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.getAppUsers method
 */
public class FriendsGetAppUsersQuery extends AbstractQueryBuilder<FriendsGetAppUsersQuery, List<Integer>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsGetAppUsersQuery(VkApiClient client, UserActor actor) {
        super(client, "friends.getAppUsers", Utils.buildParametrizedType(List.class, Integer.class));
        accessToken(actor.getAccessToken());
    }

    @Override
    protected FriendsGetAppUsersQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
