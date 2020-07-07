package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.notes.NotesAddQuery;
import com.vk.api.sdk.queries.notes.NotesCreateCommentQuery;
import com.vk.api.sdk.queries.notes.NotesDeleteCommentQuery;
import com.vk.api.sdk.queries.notes.NotesDeleteQuery;
import com.vk.api.sdk.queries.notes.NotesEditCommentQuery;
import com.vk.api.sdk.queries.notes.NotesEditQuery;
import com.vk.api.sdk.queries.notes.NotesGetByIdQuery;
import com.vk.api.sdk.queries.notes.NotesGetCommentsQuery;
import com.vk.api.sdk.queries.notes.NotesGetQuery;
import com.vk.api.sdk.queries.notes.NotesRestoreCommentQuery;

/**
 * List of Notes methods
 */
public class Notes extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Notes(VkApiClient client) {
        super(client);
    }

    /**
     * Creates a new note for the current user.
     *
     * @param actor vk actor
     * @param title Note title.
     * @param text Note text.
     * @return query
     */
    public NotesAddQuery add(UserActor actor, String title, String text) {
        return new NotesAddQuery(getClient(), actor, title, text);
    }

    /**
     * Adds a new comment on a note.
     *
     * @param actor vk actor
     * @param noteId Note ID.
     * @param message Comment text.
     * @return query
     */
    public NotesCreateCommentQuery createComment(UserActor actor, int noteId, String message) {
        return new NotesCreateCommentQuery(getClient(), actor, noteId, message);
    }

    /**
     * Deletes a note of the current user.
     *
     * @param actor vk actor
     * @param noteId Note ID.
     * @return query
     */
    public NotesDeleteQuery delete(UserActor actor, int noteId) {
        return new NotesDeleteQuery(getClient(), actor, noteId);
    }

    /**
     * Deletes a comment on a note.
     *
     * @param actor vk actor
     * @param commentId Comment ID.
     * @return query
     */
    public NotesDeleteCommentQuery deleteComment(UserActor actor, int commentId) {
        return new NotesDeleteCommentQuery(getClient(), actor, commentId);
    }

    /**
     * Edits a note of the current user.
     *
     * @param actor vk actor
     * @param noteId Note ID.
     * @param title Note title.
     * @param text Note text.
     * @return query
     */
    public NotesEditQuery edit(UserActor actor, int noteId, String title, String text) {
        return new NotesEditQuery(getClient(), actor, noteId, title, text);
    }

    /**
     * Edits a comment on a note.
     *
     * @param actor vk actor
     * @param commentId Comment ID.
     * @param message New comment text.
     * @return query
     */
    public NotesEditCommentQuery editComment(UserActor actor, int commentId, String message) {
        return new NotesEditCommentQuery(getClient(), actor, commentId, message);
    }

    /**
     * Returns a list of notes created by a user.
     *
     * @param actor vk actor
     * @return query
     */
    public NotesGetQuery get(UserActor actor) {
        return new NotesGetQuery(getClient(), actor);
    }

    /**
     * Returns a note by its ID.
     *
     * @param actor vk actor
     * @param noteId Note ID.
     * @return query
     */
    public NotesGetByIdQuery getById(UserActor actor, int noteId) {
        return new NotesGetByIdQuery(getClient(), actor, noteId);
    }

    /**
     * Returns a list of comments on a note.
     *
     * @param actor vk actor
     * @param noteId Note ID.
     * @return query
     */
    public NotesGetCommentsQuery getComments(UserActor actor, int noteId) {
        return new NotesGetCommentsQuery(getClient(), actor, noteId);
    }

    /**
     * Restores a deleted comment on a note.
     *
     * @param actor vk actor
     * @param commentId Comment ID.
     * @return query
     */
    public NotesRestoreCommentQuery restoreComment(UserActor actor, int commentId) {
        return new NotesRestoreCommentQuery(getClient(), actor, commentId);
    }
}
