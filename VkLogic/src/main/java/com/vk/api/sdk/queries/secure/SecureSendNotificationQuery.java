package com.vk.api.sdk.queries.secure;

import com.vk.api.sdk.client.AbstractSecureQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Secure.sendNotification method
 */
public class SecureSendNotificationQuery extends AbstractSecureQueryBuilder<SecureSendNotificationQuery, List<Integer>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param message value of "message" parameter.
     */
    public SecureSendNotificationQuery(VkApiClient client, ServiceActor actor, String message) {
        super(client, "secure.sendNotification", Utils.buildParametrizedType(List.class, Integer.class));
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        message(message);
    }

    /**
     * Set user id
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSendNotificationQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Notification text which should be sent in 'UTF-8' encoding ('254' characters maximum).
     *
     * @param value value of "message" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected SecureSendNotificationQuery message(String value) {
        return unsafeParam("message", value);
    }

    /**
     * user_ids
     * Set user ids
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSendNotificationQuery userIds(Integer... value) {
        return unsafeParam("user_ids", value);
    }

    /**
     * Set user ids
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSendNotificationQuery userIds(List<Integer> value) {
        return unsafeParam("user_ids", value);
    }

    @Override
    protected SecureSendNotificationQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("message", "access_token");
    }
}
