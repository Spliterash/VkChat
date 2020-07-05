package com.vk.api.sdk.queries.prettycards;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for PrettyCards.getUploadURL method
 */
public class PrettyCardsGetUploadURLQuery extends AbstractQueryBuilder<PrettyCardsGetUploadURLQuery, String> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public PrettyCardsGetUploadURLQuery(VkApiClient client, UserActor actor) {
        super(client, "prettyCards.getUploadURL", String.class);
        accessToken(actor.getAccessToken());
    }

    @Override
    protected PrettyCardsGetUploadURLQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
