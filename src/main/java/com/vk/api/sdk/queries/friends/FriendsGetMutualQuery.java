package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.getMutual method
 */
public class FriendsGetMutualQuery extends AbstractQueryBuilder<FriendsGetMutualQuery, List<Integer>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsGetMutualQuery(VkApiClient client, UserActor actor) {
        super(client, "friends.getMutual", Utils.buildParametrizedType(List.class, Integer.class));
        accessToken(actor.getAccessToken());
    }

    /**
     * ID of the user whose friends will be checked against the friends of the user specified in 'target_uid'.
     *
     * @param value value of "source uid" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery sourceUid(Integer value) {
        return unsafeParam("source_uid", value);
    }

    /**
     * ID of the user whose friends will be checked against the friends of the user specified in 'source_uid'.
     *
     * @param value value of "target uid" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery targetUid(Integer value) {
        return unsafeParam("target_uid", value);
    }

    /**
     * Sort order: 'random' — random order
     *
     * @param value value of "order" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery order(String value) {
        return unsafeParam("order", value);
    }

    /**
     * Number of mutual friends to return.
     *
     * @param value value of "count" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Offset needed to return a specific subset of mutual friends.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * target_uids
     * IDs of the users whose friends will be checked against the friends of the user specified in 'source_uid'.
     *
     * @param value value of "target uids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery targetUids(Integer... value) {
        return unsafeParam("target_uids", value);
    }

    /**
     * IDs of the users whose friends will be checked against the friends of the user specified in 'source_uid'.
     *
     * @param value value of "target uids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetMutualQuery targetUids(List<Integer> value) {
        return unsafeParam("target_uids", value);
    }

    @Override
    protected FriendsGetMutualQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
