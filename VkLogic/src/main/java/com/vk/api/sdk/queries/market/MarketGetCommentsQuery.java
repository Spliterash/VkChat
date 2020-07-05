package com.vk.api.sdk.queries.market;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.MarketSort;
import com.vk.api.sdk.objects.market.responses.GetCommentsResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Market.getComments method
 */
public class MarketGetCommentsQuery extends AbstractQueryBuilder<MarketGetCommentsQuery, GetCommentsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param itemId value of "item id" parameter. Minimum is 0.
     */
    public MarketGetCommentsQuery(VkApiClient client, UserActor actor, int ownerId, int itemId) {
        super(client, "market.getComments", GetCommentsResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        itemId(itemId);
    }

    /**
     * ID of an item owner community
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketGetCommentsQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Item ID.
     *
     * @param value value of "item id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketGetCommentsQuery itemId(int value) {
        return unsafeParam("item_id", value);
    }

    /**
     * '1' — to return likes info.
     *
     * @param value value of "need likes" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery needLikes(Boolean value) {
        return unsafeParam("need_likes", value);
    }

    /**
     * ID of a comment to start a list from (details below).
     *
     * @param value value of "start comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery startCommentId(Integer value) {
        return unsafeParam("start_comment_id", value);
    }

    /**
     * Set offset
     *
     * @param value value of "offset" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of results to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Sort order ('asc' — from old to new, 'desc' — from new to old)
     *
     * @param value value of "sort" parameter. By default asc.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery sort(MarketSort value) {
        return unsafeParam("sort", value);
    }

    /**
     * '1' — comments will be returned as numbered objects, in addition lists of 'profiles' and 'groups' objects will be returned.
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * fields
     * List of additional profile fields to return. See the [vk.com/dev/fields|details]
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * List of additional profile fields to return. See the [vk.com/dev/fields|details]
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetCommentsQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MarketGetCommentsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("item_id", "owner_id", "access_token");
    }
}
