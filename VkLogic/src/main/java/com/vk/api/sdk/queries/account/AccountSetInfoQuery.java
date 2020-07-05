package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.setInfo method
 */
public class AccountSetInfoQuery extends AbstractQueryBuilder<AccountSetInfoQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AccountSetInfoQuery(VkApiClient client, UserActor actor) {
        super(client, "account.setInfo", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Setting name.
     *
     * @param value value of "name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetInfoQuery name(String value) {
        return unsafeParam("name", value);
    }

    /**
     * Setting value.
     *
     * @param value value of "value" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetInfoQuery value(String value) {
        return unsafeParam("value", value);
    }

    @Override
    protected AccountSetInfoQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
