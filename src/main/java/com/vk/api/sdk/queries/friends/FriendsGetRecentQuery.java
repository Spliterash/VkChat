package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.getRecent method
 */
public class FriendsGetRecentQuery extends AbstractQueryBuilder<FriendsGetRecentQuery, List<Integer>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsGetRecentQuery(VkApiClient client, UserActor actor) {
        super(client, "friends.getRecent", Utils.buildParametrizedType(List.class, Integer.class));
        accessToken(actor.getAccessToken());
    }

    /**
     * Number of recently added friends to return.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 100.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRecentQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    @Override
    protected FriendsGetRecentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
