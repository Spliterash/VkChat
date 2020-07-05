package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.reorderVideos method
 */
public class VideoReorderVideosQuery extends AbstractQueryBuilder<VideoReorderVideosQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param videoId value of "video id" parameter. Minimum is 0.
     */
    public VideoReorderVideosQuery(VkApiClient client, UserActor actor, int ownerId, int videoId) {
        super(client, "video.reorderVideos", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        videoId(videoId);
    }

    /**
     * ID of the user or community that owns the album with videos.
     *
     * @param value value of "target id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery targetId(Integer value) {
        return unsafeParam("target_id", value);
    }

    /**
     * ID of the video album.
     *
     * @param value value of "album id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery albumId(Integer value) {
        return unsafeParam("album_id", value);
    }

    /**
     * ID of the user or community that owns the video.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoReorderVideosQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * ID of the video.
     *
     * @param value value of "video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoReorderVideosQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * ID of the user or community that owns the video before which the video in question shall be placed.
     *
     * @param value value of "before owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery beforeOwnerId(Integer value) {
        return unsafeParam("before_owner_id", value);
    }

    /**
     * ID of the video before which the video in question shall be placed.
     *
     * @param value value of "before video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery beforeVideoId(Integer value) {
        return unsafeParam("before_video_id", value);
    }

    /**
     * ID of the user or community that owns the video after which the photo in question shall be placed.
     *
     * @param value value of "after owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery afterOwnerId(Integer value) {
        return unsafeParam("after_owner_id", value);
    }

    /**
     * ID of the video after which the photo in question shall be placed.
     *
     * @param value value of "after video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoReorderVideosQuery afterVideoId(Integer value) {
        return unsafeParam("after_video_id", value);
    }

    @Override
    protected VideoReorderVideosQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "owner_id", "access_token");
    }
}
