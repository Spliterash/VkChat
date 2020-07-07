package com.vk.api.sdk.queries.secure;

import com.vk.api.sdk.client.AbstractSecureQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Secure.getAppBalance method
 */
public class SecureGetAppBalanceQuery extends AbstractSecureQueryBuilder<SecureGetAppBalanceQuery, Integer> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public SecureGetAppBalanceQuery(VkApiClient client, ServiceActor actor) {
        super(client, "secure.getAppBalance", Integer.class);
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
    }

    @Override
    protected SecureGetAppBalanceQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
