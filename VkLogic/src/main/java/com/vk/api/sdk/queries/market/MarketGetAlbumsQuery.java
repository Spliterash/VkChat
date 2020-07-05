package com.vk.api.sdk.queries.market;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.market.responses.GetAlbumsResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Market.getAlbums method
 */
public class MarketGetAlbumsQuery extends AbstractQueryBuilder<MarketGetAlbumsQuery, GetAlbumsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     */
    public MarketGetAlbumsQuery(VkApiClient client, UserActor actor, int ownerId) {
        super(client, "market.getAlbums", GetAlbumsResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
    }

    /**
     * ID of an items owner community.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketGetAlbumsQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Offset needed to return a specific subset of results.
     *
     * @param value value of "offset" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetAlbumsQuery offset(Integer value) {
        return unsafeParam("offset", value);
    }

    /**
     * Number of items to return.
     *
     * @param value value of "count" parameter. Maximum is 100. Minimum is 0. By default 50.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketGetAlbumsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    @Override
    protected MarketGetAlbumsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("owner_id", "access_token");
    }
}
