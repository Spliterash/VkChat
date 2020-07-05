package com.vk.api.sdk.queries.stats;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Stats.trackVisitor method
 */
public class StatsTrackVisitorQuery extends AbstractQueryBuilder<StatsTrackVisitorQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param id value of "id" parameter.
     */
    public StatsTrackVisitorQuery(VkApiClient client, UserActor actor, String id) {
        super(client, "stats.trackVisitor", OkResponse.class);
        accessToken(actor.getAccessToken());
        id(id);
    }

    /**
     * Set id
     *
     * @param value value of "id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StatsTrackVisitorQuery id(String value) {
        return unsafeParam("id", value);
    }

    @Override
    protected StatsTrackVisitorQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("id", "access_token");
    }
}
