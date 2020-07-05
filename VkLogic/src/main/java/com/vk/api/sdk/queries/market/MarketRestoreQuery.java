package com.vk.api.sdk.queries.market;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Market.restore method
 */
public class MarketRestoreQuery extends AbstractQueryBuilder<MarketRestoreQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param itemId value of "item id" parameter. Minimum is 0.
     */
    public MarketRestoreQuery(VkApiClient client, UserActor actor, int ownerId, int itemId) {
        super(client, "market.restore", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        itemId(itemId);
    }

    /**
     * ID of an item owner community.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketRestoreQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Deleted item ID.
     *
     * @param value value of "item id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketRestoreQuery itemId(int value) {
        return unsafeParam("item_id", value);
    }

    @Override
    protected MarketRestoreQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("item_id", "owner_id", "access_token");
    }
}
