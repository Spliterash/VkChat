package com.vk.api.sdk.queries.ads;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Ads.getVideoUploadURL method
 */
public class AdsGetVideoUploadURLQuery extends AbstractQueryBuilder<AdsGetVideoUploadURLQuery, String> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public AdsGetVideoUploadURLQuery(VkApiClient client, UserActor actor) {
        super(client, "ads.getVideoUploadURL", String.class);
        accessToken(actor.getAccessToken());
    }

    @Override
    protected AdsGetVideoUploadURLQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
