package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.responses.IsMemberExtendedResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.isMember method
 */
public class GroupsIsMemberQueryWithExtended extends AbstractQueryBuilder<GroupsIsMemberQueryWithExtended, IsMemberExtendedResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter.
     */
    public GroupsIsMemberQueryWithExtended(VkApiClient client, UserActor actor, String groupId) {
        super(client, "groups.isMember", IsMemberExtendedResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter.
     */
    public GroupsIsMemberQueryWithExtended(VkApiClient client, GroupActor actor, String groupId) {
        super(client, "groups.isMember", IsMemberExtendedResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
        extended(true);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter.
     */
    public GroupsIsMemberQueryWithExtended(VkApiClient client, ServiceActor actor, String groupId) {
        super(client, "groups.isMember", IsMemberExtendedResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        groupId(groupId);
        extended(true);
    }

    /**
     * ID or screen name of the community.
     *
     * @param value value of "group id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsIsMemberQueryWithExtended groupId(String value) {
        return unsafeParam("group_id", value);
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsIsMemberQueryWithExtended userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * '1' — to return an extended response with additional fields. By default: '0'.
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsIsMemberQueryWithExtended extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * user_ids
     * User IDs.
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsIsMemberQueryWithExtended userIds(Integer... value) {
        return unsafeParam("user_ids", value);
    }

    /**
     * User IDs.
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsIsMemberQueryWithExtended userIds(List<Integer> value) {
        return unsafeParam("user_ids", value);
    }

    @Override
    protected GroupsIsMemberQueryWithExtended getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
