package com.vk.api.sdk.queries.apps;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.apps.responses.GetScopesResponse;
import com.vk.api.sdk.objects.enums.AppsType;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Apps.getScopes method
 */
public class AppsGetScopesQuery extends AbstractQueryBuilder<AppsGetScopesQuery, GetScopesResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AppsGetScopesQuery(VkApiClient client, UserActor actor) {
        super(client, "apps.getScopes", GetScopesResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Set type
     *
     * @param value value of "type" parameter. By default user.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetScopesQuery type(AppsType value) {
        return unsafeParam("type", value);
    }

    @Override
    protected AppsGetScopesQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
