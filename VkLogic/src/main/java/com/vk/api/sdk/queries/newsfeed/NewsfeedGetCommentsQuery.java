package com.vk.api.sdk.queries.newsfeed;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.newsfeed.CommentsFilters;
import com.vk.api.sdk.objects.newsfeed.responses.GetCommentsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Newsfeed.getComments method
 */
public class NewsfeedGetCommentsQuery extends AbstractQueryBuilder<NewsfeedGetCommentsQuery, GetCommentsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public NewsfeedGetCommentsQuery(VkApiClient client, UserActor actor) {
        super(client, "newsfeed.getComments", GetCommentsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Number of comments to return. For auto feed, you can use the 'new_offset' parameter returned by this method.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 30.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Object ID, comments on repost of which shall be returned, e.g. 'wall1_45486'. (If the parameter is set, the 'filters' parameter is optional.),
     *
     * @param value value of "reposts" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery reposts(String value) {
        return unsafeParam("reposts", value);
    }

    /**
     * Earliest timestamp (in Unix time) of a comment to return. By default, 24 hours ago.
     *
     * @param value value of "start time" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery startTime(Integer value) {
        return unsafeParam("start_time", value);
    }

    /**
     * Latest timestamp (in Unix time) of a comment to return. By default, the current time.
     *
     * @param value value of "end time" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery endTime(Integer value) {
        return unsafeParam("end_time", value);
    }

    /**
     * Set last comments count
     *
     * @param value value of "last comments count" parameter. Maximum is 10. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery lastCommentsCount(Integer value) {
        return unsafeParam("last_comments_count", value);
    }

    /**
     * Identificator needed to return the next page with results. Value for this parameter returns in 'next_from' field.
     *
     * @param value value of "start from" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery startFrom(String value) {
        return unsafeParam("start_from", value);
    }

    /**
     * filters
     * Filters to apply: 'post' — new comments on wall posts, 'photo' — new comments on photos, 'video' — new comments on videos, 'topic' — new comments on discussions, 'note' — new comments on notes,
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery filters(CommentsFilters... value) {
        return unsafeParam("filters", value);
    }

    /**
     * Filters to apply: 'post' — new comments on wall posts, 'photo' — new comments on photos, 'video' — new comments on videos, 'topic' — new comments on discussions, 'note' — new comments on notes,
     *
     * @param value value of "filters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery filters(List<CommentsFilters> value) {
        return unsafeParam("filters", value);
    }

    /**
     * fields
     * Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetCommentsQuery fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected NewsfeedGetCommentsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
