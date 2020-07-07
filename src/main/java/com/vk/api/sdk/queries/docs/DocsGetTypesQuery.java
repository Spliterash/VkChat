package com.vk.api.sdk.queries.docs;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.docs.responses.GetTypesResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Docs.getTypes method
 */
public class DocsGetTypesQuery extends AbstractQueryBuilder<DocsGetTypesQuery, GetTypesResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     */
    public DocsGetTypesQuery(VkApiClient client, UserActor actor, int ownerId) {
        super(client, "docs.getTypes", GetTypesResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
    }

    /**
     * ID of the user or community that owns the documents. Use a negative value to designate a community ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected DocsGetTypesQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    @Override
    protected DocsGetTypesQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("owner_id", "access_token");
    }
}
