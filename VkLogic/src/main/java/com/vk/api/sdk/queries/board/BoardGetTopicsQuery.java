package com.vk.api.sdk.queries.board;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.board.responses.GetTopicsResponse;
import com.vk.api.sdk.objects.enums.BoardOrder;
import com.vk.api.sdk.objects.enums.BoardPreview;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Board.getTopics method
 */
public class BoardGetTopicsQuery extends AbstractQueryBuilder<BoardGetTopicsQuery, GetTopicsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public BoardGetTopicsQuery(VkApiClient client, UserActor actor, int groupId) {
        super(client, "board.getTopics", GetTopicsResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public BoardGetTopicsQuery(VkApiClient client, ServiceActor actor, int groupId) {
        super(client, "board.getTopics", GetTopicsResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        groupId(groupId);
    }

    /**
     * ID of the community that owns the discussion board.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected BoardGetTopicsQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Sort order: '1' — by date updated in reverse chronological order. '2' — by date created in reverse chronological order. '-1' — by date updated in chronological order. '-2' — by date created in chronological order. If no sort order is specified, topics are returned in the order specified by the group administrator. Pinned topics are returned first, regardless of the sorting.
     *
     * @param value value of "order" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery order(BoardOrder value) {
        return unsafeParam("order", value);
    }

    /**
     * Offset needed to return a specific subset of topics.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of topics to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 40.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return information about users who created topics or who posted there last, '0' — to return no additional fields (default)
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * '1' — to return the first comment in each topic,, '2' — to return the last comment in each topic,, '0' — to return no comments. By default: '0'.
     *
     * @param value value of "preview" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery preview(BoardPreview value) {
        return unsafeParam("preview", value);
    }

    /**
     * Number of characters after which to truncate the previewed comment. To preview the full comment, specify '0'.
     *
     * @param value value of "preview length" parameter. Minimum is 0. By default 90.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery previewLength(Integer value) {
        return unsafeParam("preview_length", value);
    }

    /**
     * topic_ids
     * IDs of topics to be returned (100 maximum). By default, all topics are returned. If this parameter is set, the 'order', 'offset', and 'count' parameters are ignored.
     *
     * @param value value of "topic ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery topicIds(Integer... value) {
        return unsafeParam("topic_ids", value);
    }

    /**
     * IDs of topics to be returned (100 maximum). By default, all topics are returned. If this parameter is set, the 'order', 'offset', and 'count' parameters are ignored.
     *
     * @param value value of "topic ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public BoardGetTopicsQuery topicIds(List<Integer> value) {
        return unsafeParam("topic_ids", value);
    }

    @Override
    protected BoardGetTopicsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
