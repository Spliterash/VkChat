package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.confirmTag method
 */
public class PhotosConfirmTagQuery extends AbstractQueryBuilder<PhotosConfirmTagQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param photoId value of "photo id" parameter.
     * @param tagId value of "tag id" parameter.
     */
    public PhotosConfirmTagQuery(VkApiClient client, UserActor actor, String photoId, int tagId) {
        super(client, "photos.confirmTag", OkResponse.class);
        accessToken(actor.getAccessToken());
        photoId(photoId);
        tagId(tagId);
    }

    /**
     * ID of the user or community that owns the photo.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosConfirmTagQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Photo ID.
     *
     * @param value value of "photo id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosConfirmTagQuery photoId(String value) {
        return unsafeParam("photo_id", value);
    }

    /**
     * Tag ID.
     *
     * @param value value of "tag id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosConfirmTagQuery tagId(int value) {
        return unsafeParam("tag_id", value);
    }

    @Override
    protected PhotosConfirmTagQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("photo_id", "tag_id", "access_token");
    }
}
