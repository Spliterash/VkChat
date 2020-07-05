package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.docs.DocsAddQuery;
import com.vk.api.sdk.queries.docs.DocsDeleteQuery;
import com.vk.api.sdk.queries.docs.DocsEditQuery;
import com.vk.api.sdk.queries.docs.DocsGetByIdQuery;
import com.vk.api.sdk.queries.docs.DocsGetMessagesUploadServerQuery;
import com.vk.api.sdk.queries.docs.DocsGetQuery;
import com.vk.api.sdk.queries.docs.DocsGetTypesQuery;
import com.vk.api.sdk.queries.docs.DocsGetUploadServerQuery;
import com.vk.api.sdk.queries.docs.DocsGetWallUploadServerQuery;
import com.vk.api.sdk.queries.docs.DocsSaveQuery;
import com.vk.api.sdk.queries.docs.DocsSearchQuery;
import java.util.List;

/**
 * List of Docs methods
 */
public class Docs extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Docs(VkApiClient client) {
        super(client);
    }

    /**
     * Copies a document to a user's or community's document list.
     *
     * @param actor vk actor
     * @param ownerId ID of the user or community that owns the document. Use a negative value to designate a community ID.
     * @param docId Document ID.
     * @return query
     */
    public DocsAddQuery add(UserActor actor, int ownerId, int docId) {
        return new DocsAddQuery(getClient(), actor, ownerId, docId);
    }

    /**
     * Deletes a user or community document.
     *
     * @param actor vk actor
     * @param ownerId ID of the user or community that owns the document. Use a negative value to designate a community ID.
     * @param docId Document ID.
     * @return query
     */
    public DocsDeleteQuery delete(UserActor actor, int ownerId, int docId) {
        return new DocsDeleteQuery(getClient(), actor, ownerId, docId);
    }

    /**
     * Edits a document.
     *
     * @param actor vk actor
     * @param ownerId User ID or community ID. Use a negative value to designate a community ID.
     * @param docId Document ID.
     * @return query
     */
    public DocsEditQuery edit(UserActor actor, int ownerId, int docId) {
        return new DocsEditQuery(getClient(), actor, ownerId, docId);
    }

    /**
     * Returns detailed information about user or community documents.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetQuery get(UserActor actor) {
        return new DocsGetQuery(getClient(), actor);
    }

    /**
     * Returns information about documents by their IDs.
     *
     * @param actor vk actor
     * @param docs Document IDs. Example: , "66748_91488,66748_91455",
     * @return query
     */
    public DocsGetByIdQuery getById(UserActor actor, String... docs) {
        return new DocsGetByIdQuery(getClient(), actor, docs);
    }

    /**
     * Returns information about documents by their IDs.
     *
     * @param actor vk actor
     * @param docs Document IDs. Example: , "66748_91488,66748_91455",
     * @return query
     */
    public DocsGetByIdQuery getById(UserActor actor, List<String> docs) {
        return new DocsGetByIdQuery(getClient(), actor, docs);
    }

    /**
     * Returns the server address for document upload.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetMessagesUploadServerQuery getMessagesUploadServer(UserActor actor) {
        return new DocsGetMessagesUploadServerQuery(getClient(), actor);
    }

    /**
     * Returns the server address for document upload.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetMessagesUploadServerQuery getMessagesUploadServer(GroupActor actor) {
        return new DocsGetMessagesUploadServerQuery(getClient(), actor);
    }

    /**
     * Returns documents types available for current user.
     *
     * @param actor vk actor
     * @param ownerId ID of the user or community that owns the documents. Use a negative value to designate a community ID.
     * @return query
     */
    public DocsGetTypesQuery getTypes(UserActor actor, int ownerId) {
        return new DocsGetTypesQuery(getClient(), actor, ownerId);
    }

    /**
     * Returns the server address for document upload.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetUploadServerQuery getUploadServer(UserActor actor) {
        return new DocsGetUploadServerQuery(getClient(), actor);
    }

    /**
     * Returns the server address for document upload onto a user's or community's wall.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetWallUploadServerQuery getWallUploadServer(UserActor actor) {
        return new DocsGetWallUploadServerQuery(getClient(), actor);
    }

    /**
     * Returns the server address for document upload onto a user's or community's wall.
     *
     * @param actor vk actor
     * @return query
     */
    public DocsGetWallUploadServerQuery getWallUploadServer(GroupActor actor) {
        return new DocsGetWallUploadServerQuery(getClient(), actor);
    }

    /**
     * Saves a document after [vk.com/dev/upload_files_2|uploading it to a server].
     *
     * @param actor vk actor
     * @param file This parameter is returned when the file is [vk.com/dev/upload_files_2|uploaded to the server].
     * @return query
     */
    public DocsSaveQuery save(UserActor actor, String file) {
        return new DocsSaveQuery(getClient(), actor, file);
    }

    /**
     * Saves a document after [vk.com/dev/upload_files_2|uploading it to a server].
     *
     * @param actor vk actor
     * @param file This parameter is returned when the file is [vk.com/dev/upload_files_2|uploaded to the server].
     * @return query
     */
    public DocsSaveQuery save(GroupActor actor, String file) {
        return new DocsSaveQuery(getClient(), actor, file);
    }

    /**
     * Returns a list of documents matching the search criteria.
     *
     * @param actor vk actor
     * @param q Search query string.
     * @return query
     */
    public DocsSearchQuery search(UserActor actor, String q) {
        return new DocsSearchQuery(getClient(), actor, q);
    }

    /**
     * Returns a list of documents matching the search criteria.
     *
     * @param actor vk actor
     * @param q Search query string.
     * @return query
     */
    public DocsSearchQuery search(GroupActor actor, String q) {
        return new DocsSearchQuery(getClient(), actor, q);
    }
}
