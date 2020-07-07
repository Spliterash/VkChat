package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.ban method
 */
public class AccountBanQuery extends AbstractQueryBuilder<AccountBanQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountBanQuery(VkApiClient client, UserActor actor) {
        super(client, "account.ban", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountBanQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    @Override
    protected AccountBanQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
