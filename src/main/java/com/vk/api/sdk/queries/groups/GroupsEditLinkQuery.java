package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.editLink method
 */
public class GroupsEditLinkQuery extends AbstractQueryBuilder<GroupsEditLinkQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     * @param linkId value of "link id" parameter. Minimum is 0.
     */
    public GroupsEditLinkQuery(VkApiClient client, UserActor actor, int groupId, int linkId) {
        super(client, "groups.editLink", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
        linkId(linkId);
    }

    /**
     * Community ID.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsEditLinkQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Link ID.
     *
     * @param value value of "link id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsEditLinkQuery linkId(int value) {
        return unsafeParam("link_id", value);
    }

    /**
     * New description text for the link.
     *
     * @param value value of "text" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsEditLinkQuery text(String value) {
        return unsafeParam("text", value);
    }

    @Override
    protected GroupsEditLinkQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "link_id", "access_token");
    }
}
