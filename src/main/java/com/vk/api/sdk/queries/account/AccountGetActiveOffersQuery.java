package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.account.responses.GetActiveOffersResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.getActiveOffers method
 */
public class AccountGetActiveOffersQuery extends AbstractQueryBuilder<AccountGetActiveOffersQuery, GetActiveOffersResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountGetActiveOffersQuery(VkApiClient client, UserActor actor) {
        super(client, "account.getActiveOffers", GetActiveOffersResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Set offset
     *
     * @param value value of "offset" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountGetActiveOffersQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of results to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 100.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountGetActiveOffersQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    @Override
    protected AccountGetActiveOffersQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
