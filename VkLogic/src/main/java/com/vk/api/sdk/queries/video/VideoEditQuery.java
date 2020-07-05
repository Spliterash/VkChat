package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.edit method
 */
public class VideoEditQuery extends AbstractQueryBuilder<VideoEditQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param videoId value of "video id" parameter.
     */
    public VideoEditQuery(VkApiClient client, UserActor actor, int videoId) {
        super(client, "video.edit", OkResponse.class);
        accessToken(actor.getAccessToken());
        videoId(videoId);
    }

    /**
     * ID of the user or community that owns the video.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Video ID.
     *
     * @param value value of "video id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoEditQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * New video title.
     *
     * @param value value of "name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery name(String value) {
        return unsafeParam("name", value);
    }

    /**
     * New video description.
     *
     * @param value value of "desc" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery desc(String value) {
        return unsafeParam("desc", value);
    }

    /**
     * Disable comments for the group video.
     *
     * @param value value of "no comments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery noComments(Boolean value) {
        return unsafeParam("no_comments", value);
    }

    /**
     * '1' — to repeat the playback of the video, '0' — to play the video once,
     *
     * @param value value of "repeat" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery repeat(Boolean value) {
        return unsafeParam("repeat", value);
    }

    /**
     * privacy_view
     * Privacy settings in a [vk.com/dev/privacy_setting|special format]. Privacy setting is available for videos uploaded to own profile by user.
     *
     * @param value value of "privacy view" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery privacyView(String... value) {
        return unsafeParam("privacy_view", value);
    }

    /**
     * Privacy settings in a [vk.com/dev/privacy_setting|special format]. Privacy setting is available for videos uploaded to own profile by user.
     *
     * @param value value of "privacy view" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery privacyView(List<String> value) {
        return unsafeParam("privacy_view", value);
    }

    /**
     * privacy_comment
     * Privacy settings for comments in a [vk.com/dev/privacy_setting|special format].
     *
     * @param value value of "privacy comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery privacyComment(String... value) {
        return unsafeParam("privacy_comment", value);
    }

    /**
     * Privacy settings for comments in a [vk.com/dev/privacy_setting|special format].
     *
     * @param value value of "privacy comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoEditQuery privacyComment(List<String> value) {
        return unsafeParam("privacy_comment", value);
    }

    @Override
    protected VideoEditQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "access_token");
    }
}
