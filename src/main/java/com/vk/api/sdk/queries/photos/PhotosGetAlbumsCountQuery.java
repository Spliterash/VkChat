package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.getAlbumsCount method
 */
public class PhotosGetAlbumsCountQuery extends AbstractQueryBuilder<PhotosGetAlbumsCountQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PhotosGetAlbumsCountQuery(VkApiClient client, UserActor actor) {
        super(client, "photos.getAlbumsCount", Integer.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetAlbumsCountQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Community ID.
     *
     * @param value value of "group id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetAlbumsCountQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected PhotosGetAlbumsCountQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
