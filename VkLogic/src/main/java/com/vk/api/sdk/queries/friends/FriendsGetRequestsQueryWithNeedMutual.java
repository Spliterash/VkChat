package com.vk.api.sdk.queries.friends;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.FriendsSort;
import com.vk.api.sdk.objects.friends.responses.GetRequestsNeedMutualResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Friends.getRequests method
 */
public class FriendsGetRequestsQueryWithNeedMutual extends AbstractQueryBuilder<FriendsGetRequestsQueryWithNeedMutual, GetRequestsNeedMutualResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public FriendsGetRequestsQueryWithNeedMutual(VkApiClient client, UserActor actor,
            Boolean needMutual) {
        super(client, "friends.getRequests", GetRequestsNeedMutualResponse.class);
        accessToken(actor.getAccessToken());
        needMutual(needMutual);
    }

    /**
     * Offset needed to return a specific subset of friend requests.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of friend requests to return (default 100, maximum 1000).
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 100.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return response messages from users who have sent a friend request or, if 'suggested' is set to '1', to return a list of suggested friends
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * '1' — to return a list of mutual friends (up to 20), if any
     *
     * @param value value of "need mutual" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected FriendsGetRequestsQueryWithNeedMutual needMutual(Boolean value) {
        return unsafeParam("need_mutual", value);
    }

    /**
     * '1' — to return outgoing requests, '0' — to return incoming requests (default)
     *
     * @param value value of "out" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual out(Boolean value) {
        return unsafeParam("out", value);
    }

    /**
     * Sort order: '1' — by number of mutual friends, '0' — by date
     *
     * @param value value of "sort" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual sort(FriendsSort value) {
        return unsafeParam("sort", value);
    }

    /**
     * Set need viewed
     *
     * @param value value of "need viewed" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual needViewed(Boolean value) {
        return unsafeParam("need_viewed", value);
    }

    /**
     * '1' — to return a list of suggested friends, '0' — to return friend requests (default)
     *
     * @param value value of "suggested" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual suggested(Boolean value) {
        return unsafeParam("suggested", value);
    }

    /**
     * Set ref
     *
     * @param value value of "ref" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual ref(String value) {
        return unsafeParam("ref", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public FriendsGetRequestsQueryWithNeedMutual fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected FriendsGetRequestsQueryWithNeedMutual getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
