package com.vk.api.sdk.queries.newsfeed;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Newsfeed.deleteList method
 */
public class NewsfeedDeleteListQuery extends AbstractQueryBuilder<NewsfeedDeleteListQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param listId value of "list id" parameter. Minimum is 0.
     */
    public NewsfeedDeleteListQuery(VkApiClient client, UserActor actor, int listId) {
        super(client, "newsfeed.deleteList", OkResponse.class);
        accessToken(actor.getAccessToken());
        listId(listId);
    }

    /**
     * Set list id
     *
     * @param value value of "list id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected NewsfeedDeleteListQuery listId(int value) {
        return unsafeParam("list_id", value);
    }

    @Override
    protected NewsfeedDeleteListQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("list_id", "access_token");
    }
}
