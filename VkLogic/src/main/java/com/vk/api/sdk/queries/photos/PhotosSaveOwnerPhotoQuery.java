package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.photos.responses.SaveOwnerPhotoResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.saveOwnerPhoto method
 */
public class PhotosSaveOwnerPhotoQuery extends AbstractQueryBuilder<PhotosSaveOwnerPhotoQuery, SaveOwnerPhotoResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PhotosSaveOwnerPhotoQuery(VkApiClient client, UserActor actor) {
        super(client, "photos.saveOwnerPhoto", SaveOwnerPhotoResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Parameter returned after [vk.com/dev/upload_files|photo upload].
     *
     * @param value value of "server" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosSaveOwnerPhotoQuery server(String value) {
        return unsafeParam("server", value);
    }

    /**
     * Parameter returned after [vk.com/dev/upload_files|photo upload].
     *
     * @param value value of "hash" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosSaveOwnerPhotoQuery hash(String value) {
        return unsafeParam("hash", value);
    }

    /**
     * Parameter returned after [vk.com/dev/upload_files|photo upload].
     *
     * @param value value of "photo" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosSaveOwnerPhotoQuery photo(String value) {
        return unsafeParam("photo", value);
    }

    @Override
    protected PhotosSaveOwnerPhotoQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
