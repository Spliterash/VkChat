package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.responses.GetCatalogResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getCatalog method
 */
public class GroupsGetCatalogQuery extends AbstractQueryBuilder<GroupsGetCatalogQuery, GetCatalogResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public GroupsGetCatalogQuery(VkApiClient client, UserActor actor) {
        super(client, "groups.getCatalog", GetCatalogResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Category id received from [vk.com/dev/groups.getCatalogInfo|groups.getCatalogInfo].
     *
     * @param value value of "category id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetCatalogQuery categoryId(Integer value) {
        return unsafeParam("category_id", value);
    }

    /**
     * Subcategory id received from [vk.com/dev/groups.getCatalogInfo|groups.getCatalogInfo].
     *
     * @param value value of "subcategory id" parameter. Maximum is 99. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetCatalogQuery subcategoryId(Integer value) {
        return unsafeParam("subcategory_id", value);
    }

    @Override
    protected GroupsGetCatalogQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
