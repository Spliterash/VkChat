package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.video.responses.GetAlbumsByVideoExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.getAlbumsByVideo method
 */
public class VideoGetAlbumsByVideoQueryWithExtended extends AbstractQueryBuilder<VideoGetAlbumsByVideoQueryWithExtended, GetAlbumsByVideoExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param videoId value of "video id" parameter. Minimum is 0.
     */
    public VideoGetAlbumsByVideoQueryWithExtended(VkApiClient client, UserActor actor, int ownerId,
            int videoId) {
        super(client, "video.getAlbumsByVideo", GetAlbumsByVideoExtendedResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        videoId(videoId);
        extended(true);
    }

    /**
     * Set target id
     *
     * @param value value of "target id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetAlbumsByVideoQueryWithExtended targetId(Integer value) {
        return unsafeParam("target_id", value);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoGetAlbumsByVideoQueryWithExtended ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set video id
     *
     * @param value value of "video id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoGetAlbumsByVideoQueryWithExtended videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * Set extended
     *
     * @param value value of "extended" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoGetAlbumsByVideoQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    @Override
    protected VideoGetAlbumsByVideoQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "owner_id", "access_token");
    }
}
