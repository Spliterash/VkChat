package com.vk.api.sdk.queries.users;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.UsersNameCase;
import com.vk.api.sdk.objects.users.Fields;
import com.vk.api.sdk.objects.users.responses.GetFollowersFieldsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Users.getFollowers method
 */
public class UsersGetFollowersQueryWithFields extends AbstractQueryBuilder<UsersGetFollowersQueryWithFields, GetFollowersFieldsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public UsersGetFollowersQueryWithFields(VkApiClient client, UserActor actor, Fields... fields) {
        super(client, "users.getFollowers", GetFollowersFieldsResponse.class);
        accessToken(actor.getAccessToken());
        fields(fields);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public UsersGetFollowersQueryWithFields(VkApiClient client, UserActor actor,
            List<Fields> fields) {
        super(client, "users.getFollowers", GetFollowersFieldsResponse.class);
        accessToken(actor.getAccessToken());
        fields(fields);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public UsersGetFollowersQueryWithFields(VkApiClient client, ServiceActor actor,
            Fields... fields) {
        super(client, "users.getFollowers", GetFollowersFieldsResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        fields(fields);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public UsersGetFollowersQueryWithFields(VkApiClient client, ServiceActor actor,
            List<Fields> fields) {
        super(client, "users.getFollowers", GetFollowersFieldsResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        fields(fields);
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public UsersGetFollowersQueryWithFields userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Offset needed to return a specific subset of followers.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public UsersGetFollowersQueryWithFields offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of followers to return.
     *
     * @param value value of "count" parameter. Maximum is 1000. Minimum is 0. By default 100.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public UsersGetFollowersQueryWithFields count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * Case for declension of user name and surname: 'nom' — nominative (default), 'gen' — genitive , 'dat' — dative, 'acc' — accusative , 'ins' — instrumental , 'abl' — prepositional
     *
     * @param value value of "name case" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public UsersGetFollowersQueryWithFields nameCase(UsersNameCase value) {
        return unsafeParam("name_case", value);
    }

    /**
     * fields
     * Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online'.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected UsersGetFollowersQueryWithFields fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online'.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected UsersGetFollowersQueryWithFields fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected UsersGetFollowersQueryWithFields getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
