package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.removeFromAlbum method
 */
public class VideoRemoveFromAlbumQuery extends AbstractQueryBuilder<VideoRemoveFromAlbumQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param videoId value of "video id" parameter. Minimum is 0.
     */
    public VideoRemoveFromAlbumQuery(VkApiClient client, UserActor actor, int ownerId,
            int videoId) {
        super(client, "video.removeFromAlbum", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        videoId(videoId);
    }

    /**
     * Set target id
     *
     * @param value value of "target id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoRemoveFromAlbumQuery targetId(Integer value) {
        return unsafeParam("target_id", value);
    }

    /**
     * Set album id
     *
     * @param value value of "album id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoRemoveFromAlbumQuery albumId(Integer value) {
        return unsafeParam("album_id", value);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoRemoveFromAlbumQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set video id
     *
     * @param value value of "video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoRemoveFromAlbumQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * album_ids
     * Set album ids
     *
     * @param value value of "album ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoRemoveFromAlbumQuery albumIds(Integer... value) {
        return unsafeParam("album_ids", value);
    }

    /**
     * Set album ids
     *
     * @param value value of "album ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoRemoveFromAlbumQuery albumIds(List<Integer> value) {
        return unsafeParam("album_ids", value);
    }

    @Override
    protected VideoRemoveFromAlbumQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "owner_id", "access_token");
    }
}
