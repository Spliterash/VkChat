package com.vk.api.sdk.queries.video;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Video.createComment method
 */
public class VideoCreateCommentQuery extends AbstractQueryBuilder<VideoCreateCommentQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param videoId value of "video id" parameter.
     */
    public VideoCreateCommentQuery(VkApiClient client, UserActor actor, int videoId) {
        super(client, "video.createComment", Integer.class);
        accessToken(actor.getAccessToken());
        videoId(videoId);
    }

    /**
     * ID of the user or community that owns the video.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Video ID.
     *
     * @param value value of "video id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected VideoCreateCommentQuery videoId(int value) {
        return unsafeParam("video_id", value);
    }

    /**
     * New comment text.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * '1' — to post the comment from a community name (only if 'owner_id'<0)
     *
     * @param value value of "from group" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery fromGroup(Boolean value) {
        return unsafeParam("from_group", value);
    }

    /**
     * Set reply to comment
     *
     * @param value value of "reply to comment" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery replyToComment(Integer value) {
        return unsafeParam("reply_to_comment", value);
    }

    /**
     * Set sticker id
     *
     * @param value value of "sticker id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery stickerId(Integer value) {
        return unsafeParam("sticker_id", value);
    }

    /**
     * Set guid
     *
     * @param value value of "guid" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery guid(String value) {
        return unsafeParam("guid", value);
    }

    /**
     * attachments
     * List of objects attached to the comment, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media attachment owner. '<media_id>' — Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    /**
     * List of objects attached to the comment, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media attachment owner. '<media_id>' — Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public VideoCreateCommentQuery attachments(List<String> value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected VideoCreateCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("video_id", "access_token");
    }
}
