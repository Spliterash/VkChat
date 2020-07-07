package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.video.responses.GetResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.get method
 */
public class VideoGetQuery extends AbstractQueryBuilder<VideoGetQuery, GetResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public VideoGetQuery(VkApiClient client, UserActor actor) {
        super(client, "video.get", GetResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * ID of the user or community that owns the video(s).
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * ID of the album containing the video(s).
     *
     * @param value value of "album id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery albumId(Integer value) {
        return unsafeParam("album_id", value);
    }

    /**
     * Number of videos to return.
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 0. By default 100.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Offset needed to return a specific subset of videos.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * '1' — to return an extended response with additional fields
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * videos
     * Video IDs, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", Use a negative value to designate a community ID. Example: "-4363_136089719,13245770_137352259"
     *
     * @param value value of "videos" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery videos(String... value) {
        return unsafeParam("videos", value);
    }

    /**
     * Video IDs, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", Use a negative value to designate a community ID. Example: "-4363_136089719,13245770_137352259"
     *
     * @param value value of "videos" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoGetQuery videos(List<String> value) {
        return unsafeParam("videos", value);
    }

    @Override
    protected VideoGetQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
