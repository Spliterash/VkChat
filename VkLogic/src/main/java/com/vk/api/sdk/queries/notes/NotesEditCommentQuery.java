package com.vk.api.sdk.queries.notes;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Notes.editComment method
 */
public class NotesEditCommentQuery extends AbstractQueryBuilder<NotesEditCommentQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param commentId value of "comment id" parameter. Minimum is 0.
     * @param message value of "message" parameter.
     */
    public NotesEditCommentQuery(VkApiClient client, UserActor actor, int commentId,
            String message) {
        super(client, "notes.editComment", OkResponse.class);
        accessToken(actor.getAccessToken());
        commentId(commentId);
        message(message);
    }

    /**
     * Comment ID.
     *
     * @param value value of "comment id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected NotesEditCommentQuery commentId(int value) {
        return unsafeParam("comment_id", value);
    }

    /**
     * Note owner ID.
     *
     * @param value value of "owner id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NotesEditCommentQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * New comment text.
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected NotesEditCommentQuery message(String value) {
        return unsafeParam("message", value);
    }

    @Override
    protected NotesEditCommentQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("message", "comment_id", "access_token");
    }
}
