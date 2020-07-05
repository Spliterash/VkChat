package com.vk.api.sdk.queries.market;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.MarketReason;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Market.report method
 */
public class MarketReportQuery extends AbstractQueryBuilder<MarketReportQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param itemId value of "item id" parameter. Minimum is 0.
     */
    public MarketReportQuery(VkApiClient client, UserActor actor, int ownerId, int itemId) {
        super(client, "market.report", OkResponse.class);
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
    protected MarketReportQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Item ID.
     *
     * @param value value of "item id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MarketReportQuery itemId(int value) {
        return unsafeParam("item_id", value);
    }

    /**
     * Complaint reason. Possible values: *'0' — spam,, *'1' — child porn,, *'2' — extremism,, *'3' — violence,, *'4' — drugs propaganda,, *'5' — adult materials,, *'6' — insult.
     *
     * @param value value of "reason" parameter. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MarketReportQuery reason(MarketReason value) {
        return unsafeParam("reason", value);
    }

    @Override
    protected MarketReportQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("item_id", "owner_id", "access_token");
    }
}
