package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.editComment method
 */
public class WallEditCommentQuery extends AbstractQueryBuilder<WallEditCommentQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param commentId value of "comment id" parameter. Minimum is 0.
     */
    public WallEditCommentQuery(VkApiClient client, UserActor actor, int commentId) {
        super(client, "wall.editComment", OkResponse.class);
        accessToken(actor.getAccessToken());
        commentId(commentId);
    }

    /**
     * User ID or community ID. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditCommentQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Comment ID.
     *
     * @param value value of "comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallEditCommentQuery commentId(int value) {
        return unsafeParam("comment_id", value);
    }

    /**
     * New comment text.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditCommentQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * attachments
     * List of objects attached to the comment, in the following format: , "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media attachment owner. '<media_id>' — Media attachment ID. For example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditCommentQuery attachments(String... value) {
        return unsafeParam("attachments", value);
    }

    /**
     * List of objects attached to the comment, in the following format: , "<owner_id>_<media_id>,<owner_id>_<media_id>", ' — Type of media attachment: 'photo' — photo, 'video' — video, 'audio' — audio, 'doc' — document, '<owner_id>' — ID of the media attachment owner. '<media_id>' — Media attachment ID. For example: "photo100172_166443618,photo66748_265827614"
     *
     * @param value value of "attachments" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallEditCommentQuery attachments(List<String> value) {
        return unsafeParam("attachments", value);
    }

    @Override
    protected WallEditCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("comment_id", "access_token");
    }
}
