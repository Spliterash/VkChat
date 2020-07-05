package com.vk.api.sdk.queries.wall;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Wall.unpin method
 */
public class WallUnpinQuery extends AbstractQueryBuilder<WallUnpinQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param postId value of "post id" parameter. Minimum is 0.
     */
    public WallUnpinQuery(VkApiClient client, UserActor actor, int postId) {
        super(client, "wall.unpin", OkResponse.class);
        accessToken(actor.getAccessToken());
        postId(postId);
    }

    /**
     * ID of the user or community that owns the wall. By default, current user ID. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public WallUnpinQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Post ID.
     *
     * @param value value of "post id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected WallUnpinQuery postId(int value) {
        return unsafeParam("post_id", value);
    }

    @Override
    protected WallUnpinQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("post_id", "access_token");
    }
}
