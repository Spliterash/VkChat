package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.restore method
 */
public class WallRestoreQuery extends AbstractQueryBuilder<WallRestoreQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public WallRestoreQuery(VkApiClient client, UserActor actor) {
        super(client, "wall.restore", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * User ID or community ID from whose wall the post was deleted. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallRestoreQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * ID of the post to be restored.
     *
     * @param value value of "post id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallRestoreQuery postId(Integer value) {
        return unsafeParam("post_id", value);
    }

    @Override
    protected WallRestoreQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
