package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.enums.WallSort;
import com.vk.api.sdk.objects.wall.responses.GetCommentsExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.getComments method
 */
public class WallGetCommentsQueryWithExtended extends AbstractQueryBuilder<WallGetCommentsQueryWithExtended, GetCommentsExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public WallGetCommentsQueryWithExtended(VkApiClient client, UserActor actor) {
        super(client, "wall.getComments", GetCommentsExtendedResponse.class);
        accessToken(actor.getAccessToken());
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public WallGetCommentsQueryWithExtended(VkApiClient client, ServiceActor actor) {
        super(client, "wall.getComments", GetCommentsExtendedResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        extended(true);
    }

    /**
     * User ID or community ID. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Post ID.
     *
     * @param value value of "post id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended postId(Integer value) {
        return unsafeParam("post_id", value);
    }

    /**
     * '1' — to return the 'likes' field, '0' — not to return the 'likes' field (default)
     *
     * @param value value of "need likes" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended needLikes(Boolean value) {
        return unsafeParam("need_likes", value);
    }

    /**
     * Set start comment id
     *
     * @param value value of "start comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended startCommentId(Integer value) {
        return unsafeParam("start_comment_id", value);
    }

    /**
     * Offset needed to return a specific subset of comments.
     *
     * @param value value of "offset" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of comments to return (maximum 100).
     *
     * @param value value of "count" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Sort order: 'asc' — chronological, 'desc' — reverse chronological
     *
     * @param value value of "sort" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended sort(WallSort value) {
        return unsafeParam("sort", value);
    }

    /**
     * Number of characters at which to truncate comments when previewed. By default, '90'. Specify '0' if you do not want to truncate comments.
     *
     * @param value value of "preview length" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended previewLength(Integer value) {
        return unsafeParam("preview_length", value);
    }

    /**
     * Set extended
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallGetCommentsQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Comment ID.
     *
     * @param value value of "comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended commentId(Integer value) {
        return unsafeParam("comment_id", value);
    }

    /**
     * Count items in threads.
     *
     * @param value value of "thread items count" parameter. Maximum is 10. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended threadItemsCount(Integer value) {
        return unsafeParam("thread_items_count", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallGetCommentsQueryWithExtended fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected WallGetCommentsQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
