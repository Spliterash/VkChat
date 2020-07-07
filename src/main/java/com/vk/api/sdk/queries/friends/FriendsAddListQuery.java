package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.friends.responses.AddListResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.addList method
 */
public class FriendsAddListQuery extends AbstractQueryBuilder<FriendsAddListQuery, AddListResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param name value of "name" parameter.
     */
    public FriendsAddListQuery(VkApiClient client, UserActor actor, String name) {
        super(client, "friends.addList", AddListResponse.class);
        accessToken(actor.getAccessToken());
        name(name);
    }

    /**
     * Name of the friend list.
     *
     * @param value value of "name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected FriendsAddListQuery name(String value) {
        return unsafeParam("name", value);
    }

    /**
     * user_ids
     * IDs of users to be added to the friend list.
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsAddListQuery userIds(Integer... value) {
        return unsafeParam("user_ids", value);
    }

    /**
     * IDs of users to be added to the friend list.
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsAddListQuery userIds(List<Integer> value) {
        return unsafeParam("user_ids", value);
    }

    @Override
    protected FriendsAddListQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("name", "access_token");
    }
}
