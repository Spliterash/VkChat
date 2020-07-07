package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.editAlbum method
 */
public class PhotosEditAlbumQuery extends AbstractQueryBuilder<PhotosEditAlbumQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param albumId value of "album id" parameter. Minimum is 0.
     */
    public PhotosEditAlbumQuery(VkApiClient client, UserActor actor, int albumId) {
        super(client, "photos.editAlbum", OkResponse.class);
        accessToken(actor.getAccessToken());
        albumId(albumId);
    }

    /**
     * ID of the photo album to be edited.
     *
     * @param value value of "album id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosEditAlbumQuery albumId(int value) {
        return unsafeParam("album_id", value);
    }

    /**
     * New album title.
     *
     * @param value value of "title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery title(String value) {
        return unsafeParam("title", value);
    }

    /**
     * New album description.
     *
     * @param value value of "description" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery description(String value) {
        return unsafeParam("description", value);
    }

    /**
     * ID of the user or community that owns the album.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set upload by admins only
     *
     * @param value value of "upload by admins only" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery uploadByAdminsOnly(Boolean value) {
        return unsafeParam("upload_by_admins_only", value);
    }

    /**
     * Set comments disabled
     *
     * @param value value of "comments disabled" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery commentsDisabled(Boolean value) {
        return unsafeParam("comments_disabled", value);
    }

    /**
     * privacy_view
     * Set privacy view
     *
     * @param value value of "privacy view" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery privacyView(String... value) {
        return unsafeParam("privacy_view", value);
    }

    /**
     * Set privacy view
     *
     * @param value value of "privacy view" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery privacyView(List<String> value) {
        return unsafeParam("privacy_view", value);
    }

    /**
     * privacy_comment
     * Set privacy comment
     *
     * @param value value of "privacy comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery privacyComment(String... value) {
        return unsafeParam("privacy_comment", value);
    }

    /**
     * Set privacy comment
     *
     * @param value value of "privacy comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosEditAlbumQuery privacyComment(List<String> value) {
        return unsafeParam("privacy_comment", value);
    }

    @Override
    protected PhotosEditAlbumQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("album_id", "access_token");
    }
}
