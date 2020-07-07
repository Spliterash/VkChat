package com.vk.api.sdk.queries.secure;

import com.vk.api.sdk.client.AbstractSecureQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Secure.setCounter method
 */
public class SecureSetCounterQuery extends AbstractSecureQueryBuilder<SecureSetCounterQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public SecureSetCounterQuery(VkApiClient client, ServiceActor actor) {
        super(client, "secure.setCounter", OkResponse.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
    }

    /**
     * Set user id
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSetCounterQuery userId(Integer value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Counter value.
     *
     * @param value value of "counter" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSetCounterQuery counter(Integer value) {
        return unsafeParam("counter", value);
    }

    /**
     * Set increment
     *
     * @param value value of "increment" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSetCounterQuery increment(Boolean value) {
        return unsafeParam("increment", value);
    }

    /**
     * counters
     * Set counters
     *
     * @param value value of "counters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSetCounterQuery counters(String... value) {
        return unsafeParam("counters", value);
    }

    /**
     * Set counters
     *
     * @param value value of "counters" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public SecureSetCounterQuery counters(List<String> value) {
        return unsafeParam("counters", value);
    }

    @Override
    protected SecureSetCounterQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
