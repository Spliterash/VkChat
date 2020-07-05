package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.friends.responses.DeleteResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.delete method
 */
public class FriendsDeleteQuery extends AbstractQueryBuilder<FriendsDeleteQuery, DeleteResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsDeleteQuery(VkApiClient client, UserActor actor) {
        super(client, "friends.delete", DeleteResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * ID of the user whose friend request is to be declined or who is to be deleted from the current user's friend list.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsDeleteQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    @Override
    protected FriendsDeleteQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
