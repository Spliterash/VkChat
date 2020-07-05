package com.vk.api.sdk.queries.photos;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.photos.responses.GetNewTagsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Photos.getNewTags method
 */
public class PhotosGetNewTagsQuery extends AbstractQueryBuilder<PhotosGetNewTagsQuery, GetNewTagsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PhotosGetNewTagsQuery(VkApiClient client, UserActor actor) {
        super(client, "photos.getNewTags", GetNewTagsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Offset needed to return a specific subset of photos.
     *
     * @param value value of "offset" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetNewTagsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of photos to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PhotosGetNewTagsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    @Override
    protected PhotosGetNewTagsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
