package com.vk.api.sdk.queries.apps;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.AppsType;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Apps.sendRequest method
 */
public class AppsSendRequestQuery extends AbstractQueryBuilder<AppsSendRequestQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param userId value of "user id" parameter. Minimum is 0.
     */
    public AppsSendRequestQuery(VkApiClient client, UserActor actor, int userId) {
        super(client, "apps.sendRequest", Integer.class);
        accessToken(actor.getAccessToken());
        userId(userId);
    }

    /**
     * Id of the user to send a request
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AppsSendRequestQuery userId(int value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Request text
     *
     * @param value value of "text" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsSendRequestQuery text(String value) {
        return unsafeParam("text", value);
    }

    /**
     * Request type. Values: 'invite' – if the request is sent to a user who does not have the app installed,, 'request' – if a user has already installed the app
     *
     * @param value value of "type" parameter. By default request.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsSendRequestQuery type(AppsType value) {
        return unsafeParam("type", value);
    }

    /**
     * Set name
     *
     * @param value value of "name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsSendRequestQuery name(String value) {
        return unsafeParam("name", value);
    }

    /**
     * Special string key to be sent with the request
     *
     * @param value value of "key" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsSendRequestQuery key(String value) {
        return unsafeParam("key", value);
    }

    /**
     * Set separate
     *
     * @param value value of "separate" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AppsSendRequestQuery separate(Boolean value) {
        return unsafeParam("separate", value);
    }

    @Override
    protected AppsSendRequestQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("user_id", "access_token");
    }
}
