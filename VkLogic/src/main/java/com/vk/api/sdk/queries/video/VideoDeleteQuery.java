package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.delete method
 */
public class VideoDeleteQuery extends AbstractQueryBuilder<VideoDeleteQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param videoId value of "video id" parameter. Minimum is 0.
     */
    public VideoDeleteQuery(VkApiClient client, UserActor actor, int videoId) {
        super(client, "video.delete", OkResponse.class);
        accessToken(actor.getAccessToken());
        videoId(videoId);
    }

    /**
     * Video ID.
     *
     * @param value value of "video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoDeleteQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * ID of the user or community that owns the video.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoDeleteQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set target id
     *
     * @param value value of "target id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoDeleteQuery targetId(Integer value) {
        return unsafeParam("target_id", value);
    }

    @Override
    protected VideoDeleteQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "access_token");
    }
}
