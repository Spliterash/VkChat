package com.vk.api.sdk.queries.groups;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.groups.Fields;
import com.vk.api.sdk.objects.groups.Filter;
import com.vk.api.sdk.objects.groups.responses.GetResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Groups.get method
 */
public class GroupsGetQuery extends AbstractQueryBuilder<GroupsGetQuery, GetResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public GroupsGetQuery(VkApiClient client, UserActor actor) {
        super(client, "groups.get", GetResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * '1' — to return complete information about a user's communities, '0' — to return a list of community IDs without any additional fields (default),
     *
     * @param value value of "extended" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * Offset needed to return a specific subset of communities.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of communities to return.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * filter
     * Types of communities to return: 'admin' — to return communities administered by the user , 'editor' — to return communities where the user is an administrator or editor, 'moder' — to return communities where the user is an administrator, editor, or moderator, 'groups' — to return only groups, 'publics' — to return only public pages, 'events' — to return only events
     *
     * @param value value of "filter" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery filter(Filter... value) {
        return unsafeParam("filter", value);
    }

    /**
     * Types of communities to return: 'admin' — to return communities administered by the user , 'editor' — to return communities where the user is an administrator or editor, 'moder' — to return communities where the user is an administrator, editor, or moderator, 'groups' — to return only groups, 'publics' — to return only public pages, 'events' — to return only events
     *
     * @param value value of "filter" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery filter(List<Filter> value) {
        return unsafeParam("filter", value);
    }

    /**
     * fields
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile fields to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public GroupsGetQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected GroupsGetQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
