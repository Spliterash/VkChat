package com.vk.api.sdk.queries.apps;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.apps.responses.GetFriendsListResponse;
import com.vk.api.sdk.objects.enums.AppsType;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Apps.getFriendsList method
 */
public class AppsGetFriendsListQuery extends AbstractQueryBuilder<AppsGetFriendsListQuery, GetFriendsListResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AppsGetFriendsListQuery(VkApiClient client, UserActor actor) {
        super(client, "apps.getFriendsList", GetFriendsListResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Set extended
     *
     * @param value value of "extended" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery extended(Boolean value) {
        return unsafeParam("extended", value);
    }

    /**
     * List size.
     *
     * @param value value of "count" parameter. Maximum is 5000. Minimum is 0. By default 20.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Set offset
     *
     * @param value value of "offset" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * List type. Possible values: * 'invite' — available for invites (don't play the game),, * 'request' — available for request (play the game). By default: 'invite'.
     *
     * @param value value of "type" parameter. By default invite.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery type(AppsType value) {
        return unsafeParam("type", value);
    }

    /**
     * fields
     * Additional profile fields, see [vk.com/dev/fields|description].
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional profile fields, see [vk.com/dev/fields|description].
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsGetFriendsListQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected AppsGetFriendsListQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
