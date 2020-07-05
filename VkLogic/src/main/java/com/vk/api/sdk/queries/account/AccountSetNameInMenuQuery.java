package com.vk.api.sdk.queries.account;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Account.setNameInMenu method
 */
public class AccountSetNameInMenuQuery extends AbstractQueryBuilder<AccountSetNameInMenuQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param userId value of "user id" parameter. Minimum is 0.
     */
    public AccountSetNameInMenuQuery(VkApiClient client, UserActor actor, int userId) {
        super(client, "account.setNameInMenu", OkResponse.class);
        accessToken(actor.getAccessToken());
        userId(userId);
    }

    /**
     * User ID.
     *
     * @param value value of "user id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AccountSetNameInMenuQuery userId(int value) {
        return unsafeParam("user_id", value);
    }

    /**
     * Application screen name.
     *
     * @param value value of "name" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AccountSetNameInMenuQuery name(String value) {
        return unsafeParam("name", value);
    }

    @Override
    protected AccountSetNameInMenuQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("user_id", "access_token");
    }
}
