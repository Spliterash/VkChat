package com.vk.api.sdk.queries.newsfeed;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.newsfeed.responses.GetListsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Newsfeed.getLists method
 */
public class NewsfeedGetListsQuery extends AbstractQueryBuilder<NewsfeedGetListsQuery, GetListsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public NewsfeedGetListsQuery(VkApiClient client, UserActor actor) {
        super(client, "newsfeed.getLists", GetListsResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Return additional list info
     *
     * @param value value of "extended" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetListsQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * list_ids
     * Numeric list identifiers.
     *
     * @param value value of "list ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetListsQuery listIds(Integer... value) {
        return unsafeParam("list_ids", value);
    }

    /**
     * Numeric list identifiers.
     *
     * @param value value of "list ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedGetListsQuery listIds(List<Integer> value) {
        return unsafeParam("list_ids", value);
    }

    @Override
    protected NewsfeedGetListsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
