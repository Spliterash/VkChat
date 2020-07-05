package com.vk.api.sdk.queries.market;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Market.deleteAlbum method
 */
public class MarketDeleteAlbumQuery extends AbstractQueryBuilder<MarketDeleteAlbumQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param albumId value of "album id" parameter. Minimum is 0.
     */
    public MarketDeleteAlbumQuery(VkApiClient client, UserActor actor, int ownerId, int albumId) {
        super(client, "market.deleteAlbum", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        albumId(albumId);
    }

    /**
     * ID of an collection owner community.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketDeleteAlbumQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Collection ID.
     *
     * @param value value of "album id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketDeleteAlbumQuery albumId(int value) {
        return unsafeParam("album_id", value);
    }

    @Override
    protected MarketDeleteAlbumQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("album_id", "owner_id", "access_token");
    }
}
