package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.responses.GetInvitesResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getInvites method
 */
public class GroupsGetInvitesQuery extends AbstractQueryBuilder<GroupsGetInvitesQuery, GetInvitesResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public GroupsGetInvitesQuery(VkApiClient client, UserActor actor) {
        super(client, "groups.getInvites", GetInvitesResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Offset needed to return a specific subset of invitations.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetInvitesQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of invitations to return.
     *
     * @param value value of "count" parameter. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetInvitesQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return additional [vk.com/dev/fields_groups|fields] for communities..
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetInvitesQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    @Override
    protected GroupsGetInvitesQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
