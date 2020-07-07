package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.createComment method
 */
public class PhotosCreateCommentQuery extends AbstractQueryBuilder<PhotosCreateCommentQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param photoId value of "photo id" parameter.
     */
    public PhotosCreateCommentQuery(VkApiClient client, UserActor actor, int photoId) {
        super(client, "photos.createComment", Integer.class);
        accessToken(actor.getAccessToken());
        photoId(photoId);
    }

    /**
     * ID of the user or community that owns the photo.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Photo ID.
     *
     * @param value value of "photo id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosCreateCommentQuery photoId(int value) {
        return unsafeParam("photo_id", value);
    }

    /**
     * Comment text.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * '1' — to post a comment from the community
     *
     * @param value value of "from group" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery fromGroup(Boolean value) {
        return unsafeParam("from_group", value);
    }

    /**
     * Set reply to comment
     *
     * @param value value of "reply to comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery replyToComment(Integer value) {
        return unsafeParam("reply_to_comment", value);
    }

    /**
     * Set sticker id
     *
     * @param value value of "sticker id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery stickerId(Integer value) {
        return unsafeParam("sticker_id", value);
    }

    /**
     * Set access key
     *
     * @param value value of "access key" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery accessKey(String value) {
        return unsafeParam("access_key", value);
    }

    /**
     * Set guid
     *
     * @param value value of "guid" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery guid(String value) {
        return unsafeParam("guid", value);
    }

    /**
     * attachments
     * (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — Media attachment owner ID. '<media_id>' — Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    /**
     * (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — Media attachment owner ID. '<media_id>' — Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosCreateCommentQuery attachments(List<String> value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected PhotosCreateCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("photo_id", "access_token");
    }
}
