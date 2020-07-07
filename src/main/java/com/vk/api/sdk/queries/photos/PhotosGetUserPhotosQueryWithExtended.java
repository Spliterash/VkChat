package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.photos.responses.GetUserPhotosExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.getUserPhotos method
 */
public class PhotosGetUserPhotosQueryWithExtended extends AbstractQueryBuilder<PhotosGetUserPhotosQueryWithExtended, GetUserPhotosExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PhotosGetUserPhotosQueryWithExtended(VkApiClient client, UserActor actor) {
        super(client, "photos.getUserPhotos", GetUserPhotosExtendedResponse.class);
        accessToken(actor.getAccessToken());
        extended(true);
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQueryWithExtended userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Offset needed to return a specific subset of photos. By default, '0'.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQueryWithExtended offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of photos to return. Maximum value is 1000.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQueryWithExtended count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return an additional 'likes' field, '0' — (default)
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PhotosGetUserPhotosQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Sort order: '1' — by date the tag was added in ascending order, '0' — by date the tag was added in descending order
     *
     * @param value value of "sort" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetUserPhotosQueryWithExtended sort(String value) {
        return unsafeParam("sort", value);
    }

    @Override
    protected PhotosGetUserPhotosQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
