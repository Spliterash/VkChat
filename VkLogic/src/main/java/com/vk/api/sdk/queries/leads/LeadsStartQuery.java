package com.vk.api.sdk.queries.leads;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.leads.Start;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Leads.start method
 */
public class LeadsStartQuery extends AbstractQueryBuilder<LeadsStartQuery, Start> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param leadId value of "lead id" parameter. Minimum is 0.
     * @param secret value of "secret" parameter.
     */
    public LeadsStartQuery(VkApiClient client, UserActor actor, int leadId, String secret) {
        super(client, "leads.start", Start.class);
        accessToken(actor.getAccessToken());
        leadId(leadId);
        secret(secret);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param leadId value of "lead id" parameter. Minimum is 0.
     * @param secret value of "secret" parameter.
     */
    public LeadsStartQuery(VkApiClient client, ServiceActor actor, int leadId, String secret) {
        super(client, "leads.start", Start.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        leadId(leadId);
        secret(secret);
    }

    /**
     * Lead ID.
     *
     * @param value value of "lead id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected LeadsStartQuery leadId(int value) {
        return unsafeParam("lead_id", value);
    }

    /**
     * Secret key from the lead testing interface.
     *
     * @param value value of "secret" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected LeadsStartQuery secret(String value) {
        return unsafeParam("secret", value);
    }

    /**
     * Set uid
     *
     * @param value value of "uid" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LeadsStartQuery uid(Integer value) {
        return unsafeParam("uid", value);
    }

    /**
     * Set aid
     *
     * @param value value of "aid" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LeadsStartQuery aid(Integer value) {
        return unsafeParam("aid", value);
    }

    /**
     * Set test mode
     *
     * @param value value of "test mode" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LeadsStartQuery testMode(Boolean value) {
        return unsafeParam("test_mode", value);
    }

    /**
     * Set force
     *
     * @param value value of "force" parameter. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public LeadsStartQuery force(Boolean value) {
        return unsafeParam("force", value);
    }

    @Override
    protected LeadsStartQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("secret", "lead_id", "access_token");
    }
}
