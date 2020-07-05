package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.deleteCallbackServer method
 */
public class GroupsDeleteCallbackServerQuery extends AbstractQueryBuilder<GroupsDeleteCallbackServerQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     * @param serverId value of "server id" parameter. Minimum is 0.
     */
    public GroupsDeleteCallbackServerQuery(VkApiClient client, UserActor actor, int groupId,
            int serverId) {
        super(client, "groups.deleteCallbackServer", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
        serverId(serverId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     * @param serverId value of "server id" parameter. Minimum is 0.
     */
    public GroupsDeleteCallbackServerQuery(VkApiClient client, GroupActor actor, int groupId,
            int serverId) {
        super(client, "groups.deleteCallbackServer", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        groupId(groupId);
        serverId(serverId);
    }

    /**
     * Set group id
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsDeleteCallbackServerQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set server id
     *
     * @param value value of "server id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsDeleteCallbackServerQuery serverId(int value) {
        return unsafeParam("server_id", value);
    }

    @Override
    protected GroupsDeleteCallbackServerQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("server_id", "group_id", "access_token");
    }
}
