package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.UserGroupFields;
import com.vk.api.sdk.objects.groups.responses.GetBannedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.getBanned method
 */
public class GroupsGetBannedQuery extends AbstractQueryBuilder<GroupsGetBannedQuery, GetBannedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public GroupsGetBannedQuery(VkApiClient client, UserActor actor, int groupId) {
        super(client, "groups.getBanned", GetBannedResponse.class);
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
    public GroupsGetBannedQuery(VkApiClient client, GroupActor actor, int groupId) {
        super(client, "groups.getBanned", GetBannedResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        groupId(groupId);
    }

    /**
     * Community ID.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsGetBannedQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Offset needed to return a specific subset of users.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetBannedQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of users to return.
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetBannedQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetBannedQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * fields
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetBannedQuery fields(UserGroupFields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Set fields
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetBannedQuery fields(List<UserGroupFields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected GroupsGetBannedQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
