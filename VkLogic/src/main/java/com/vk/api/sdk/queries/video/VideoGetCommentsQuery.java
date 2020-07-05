package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.VideoSort;
import com.vk.api.sdk.objects.video.responses.GetCommentsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.getComments method
 */
public class VideoGetCommentsQuery extends AbstractQueryBuilder<VideoGetCommentsQuery, GetCommentsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param videoId value of "video id" parameter. Minimum is 0.
     */
    public VideoGetCommentsQuery(VkApiClient client, UserActor actor, int videoId) {
        super(client, "video.getComments", GetCommentsResponse.class);
        accessToken(actor.getAccessToken());
        videoId(videoId);
    }

    /**
     * ID of the user or community that owns the video.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Video ID.
     *
     * @param value value of "video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoGetCommentsQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * '1' — to return an additional 'likes' field
     *
     * @param value value of "need likes" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery needLikes(Boolean value) {
        return unsafeParam("need_likes", value);
    }

    /**
     * Set start comment id
     *
     * @param value value of "start comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery startCommentId(Integer value) {
        return unsafeParam("start_comment_id", value);
    }

    /**
     * Offset needed to return a specific subset of comments.
     *
     * @param value value of "offset" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of comments to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Sort order: 'asc' — oldest comment first, 'desc' — newest comment first
     *
     * @param value value of "sort" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery sort(VideoSort value) {
        return unsafeParam("sort", value);
    }

    /**
     * Set extended
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery fields(String... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetCommentsQuery fields(List<String> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected VideoGetCommentsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "access_token");
    }
}
