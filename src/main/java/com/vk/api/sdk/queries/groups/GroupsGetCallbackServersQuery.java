package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.responses.GetCallbackServersResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getCallbackServers method
 */
public class GroupsGetCallbackServersQuery extends AbstractQueryBuilder<GroupsGetCallbackServersQuery, GetCallbackServersResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public GroupsGetCallbackServersQuery(VkApiClient client, UserActor actor, int groupId) {
        super(client, "groups.getCallbackServers", GetCallbackServersResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public GroupsGetCallbackServersQuery(VkApiClient client, GroupActor actor, int groupId) {
        super(client, "groups.getCallbackServers", GetCallbackServersResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        groupId(groupId);
    }

    /**
     * Set group id
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsGetCallbackServersQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * server_ids
     * Set server ids
     *
     * @param value value of "server ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetCallbackServersQuery serverIds(Integer... value) {
        return unsafeParam("server_ids", value);
    }

    /**
     * Set server ids
     *
     * @param value value of "server ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetCallbackServersQuery serverIds(List<Integer> value) {
        return unsafeParam("server_ids", value);
    }

    @Override
    protected GroupsGetCallbackServersQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
