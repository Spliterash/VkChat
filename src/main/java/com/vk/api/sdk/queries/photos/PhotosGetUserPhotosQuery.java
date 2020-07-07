package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.photos.responses.GetUserPhotosResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.getUserPhotos method
 */
public class PhotosGetUserPhotosQuery extends AbstractQueryBuilder<PhotosGetUserPhotosQuery, GetUserPhotosResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PhotosGetUserPhotosQuery(VkApiClient client, UserActor actor) {
        super(client, "photos.getUserPhotos", GetUserPhotosResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Offset needed to return a specific subset of photos. By default, '0'.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of photos to return. Maximum value is 1000.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return an additional 'likes' field, '0' — (default)
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Sort order: '1' — by date the tag was added in ascending order, '0' — by date the tag was added in descending order
     *
     * @param value value of "sort" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQuery sort(String value) {
        return unsafeParam("sort", value);
    }

    @Override
    protected PhotosGetUserPhotosQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
