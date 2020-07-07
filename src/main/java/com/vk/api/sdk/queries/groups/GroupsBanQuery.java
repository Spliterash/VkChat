package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.ban method
 */
public class GroupsBanQuery extends AbstractQueryBuilder<GroupsBanQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param groupId value of "group id" parameter. Minimum is 0.
     */
    public GroupsBanQuery(VkApiClient client, UserActor actor, int groupId) {
        super(client, "groups.ban", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(groupId);
    }

    /**
     * Set group id
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected GroupsBanQuery groupId(int value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsBanQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set end date
     *
     * @param value value of "end date" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsBanQuery endDate(Integer value) {
        return unsafeParam("end_date", value);
    }

    /**
     * Set reason
     *
     * @param value value of "reason" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsBanQuery reason(Integer value) {
        return unsafeParam("reason", value);
    }

    /**
     * Set comment
     *
     * @param value value of "comment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsBanQuery comment(String value) {
        return unsafeParam("comment", value);
    }

    /**
     * Set comment visible
     *
     * @param value value of "comment visible" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsBanQuery commentVisible(Boolean value) {
        return unsafeParam("comment_visible", value);
    }

    @Override
    protected GroupsBanQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("group_id", "access_token");
    }
}
