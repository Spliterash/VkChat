package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.setOffline method
 */
public class AccountSetOfflineQuery extends AbstractQueryBuilder<AccountSetOfflineQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountSetOfflineQuery(VkApiClient client, UserActor actor) {
        super(client, "account.setOffline", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    @Override
    protected AccountSetOfflineQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
