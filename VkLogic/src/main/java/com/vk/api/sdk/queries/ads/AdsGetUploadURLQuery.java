package com.vk.api.sdk.queries.ads;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Ads.getUploadURL method
 */
public class AdsGetUploadURLQuery extends AbstractQueryBuilder<AdsGetUploadURLQuery, String> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param adFormat value of "ad format" parameter.
     */
    public AdsGetUploadURLQuery(VkApiClient client, UserActor actor, int adFormat) {
        super(client, "ads.getUploadURL", String.class);
        accessToken(actor.getAccessToken());
        adFormat(adFormat);
    }

    /**
     * Ad format: *1 — image and text,, *2 — big image,, *3 — exclusive format,, *4 — community, square image,, *7 — special app format.
     *
     * @param value value of "ad format" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AdsGetUploadURLQuery adFormat(int value) {
        return unsafeParam("ad_format", value);
    }

    /**
     * Set icon
     *
     * @param value value of "icon" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AdsGetUploadURLQuery icon(Integer value) {
        return unsafeParam("icon", value);
    }

    @Override
    protected AdsGetUploadURLQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("ad_format", "access_token");
    }
}
