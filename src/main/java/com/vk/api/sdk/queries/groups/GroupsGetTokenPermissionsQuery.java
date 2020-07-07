package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.objects.groups.responses.GetTokenPermissionsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getTokenPermissions method
 */
public class GroupsGetTokenPermissionsQuery extends AbstractQueryBuilder<GroupsGetTokenPermissionsQuery, GetTokenPermissionsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public GroupsGetTokenPermissionsQuery(VkApiClient client, GroupActor actor) {
        super(client, "groups.getTokenPermissions", GetTokenPermissionsResponse.class);
        accessToken(actor.getAccessToken());
    }

    @Override
    protected GroupsGetTokenPermissionsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
