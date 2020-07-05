package com.vk.api.sdk.queries.stories;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Stories.banOwner method
 */
public class StoriesBanOwnerQuery extends AbstractQueryBuilder<StoriesBanOwnerQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownersIds value of "owners ids" parameter.
     */
    public StoriesBanOwnerQuery(VkApiClient client, UserActor actor, Integer... ownersIds) {
        super(client, "stories.banOwner", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownersIds(ownersIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownersIds value of "owners ids" parameter.
     */
    public StoriesBanOwnerQuery(VkApiClient client, UserActor actor, List<Integer> ownersIds) {
        super(client, "stories.banOwner", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownersIds(ownersIds);
    }

    /**
     * owners_ids
     * List of sources IDs
     *
     * @param value value of "owners ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesBanOwnerQuery ownersIds(Integer... value) {
        return unsafeParam("owners_ids", value);
    }

    /**
     * List of sources IDs
     *
     * @param value value of "owners ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesBanOwnerQuery ownersIds(List<Integer> value) {
        return unsafeParam("owners_ids", value);
    }

    @Override
    protected StoriesBanOwnerQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("owners_ids", "access_token");
    }
}
