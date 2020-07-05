package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.responses.GetCatalogInfoExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getCatalogInfo method
 */
public class GroupsGetCatalogInfoQueryWithExtended extends AbstractQueryBuilder<GroupsGetCatalogInfoQueryWithExtended, GetCatalogInfoExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public GroupsGetCatalogInfoQueryWithExtended(VkApiClient client, UserActor actor) {
        super(client, "groups.getCatalogInfo", GetCatalogInfoExtendedResponse.class);
        accessToken(actor.getAccessToken());
        extended(true);
    }

    /**
     * 1 – to return communities count and three communities for preview. By default: 0.
     *
     * @param value value of "extended" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsGetCatalogInfoQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * 1 – to return subcategories info. By default: 0.
     *
     * @param value value of "subcategories" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetCatalogInfoQueryWithExtended subcategories(Boolean value) {
        return unsafeParam("subcategories", value);
    }

    @Override
    protected GroupsGetCatalogInfoQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
