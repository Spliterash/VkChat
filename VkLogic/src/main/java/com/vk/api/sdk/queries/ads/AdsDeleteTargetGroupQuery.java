package com.vk.api.sdk.queries.ads;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Ads.deleteTargetGroup method
 */
public class AdsDeleteTargetGroupQuery extends AbstractQueryBuilder<AdsDeleteTargetGroupQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param accountId value of "account id" parameter.
     * @param targetGroupId value of "target group id" parameter.
     */
    public AdsDeleteTargetGroupQuery(VkApiClient client, UserActor actor, int accountId,
            int targetGroupId) {
        super(client, "ads.deleteTargetGroup", OkResponse.class);
        accessToken(actor.getAccessToken());
        accountId(accountId);
        targetGroupId(targetGroupId);
    }

    /**
     * Advertising account ID.
     *
     * @param value value of "account id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AdsDeleteTargetGroupQuery accountId(int value) {
        return unsafeParam("account_id", value);
    }

    /**
     * 'Only for advertising agencies.' , ID of the client with the advertising account where the group will be created.
     *
     * @param value value of "client id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public AdsDeleteTargetGroupQuery clientId(Integer value) {
        return unsafeParam("client_id", value);
    }

    /**
     * Group ID.
     *
     * @param value value of "target group id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected AdsDeleteTargetGroupQuery targetGroupId(int value) {
        return unsafeParam("target_group_id", value);
    }

    @Override
    protected AdsDeleteTargetGroupQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("target_group_id", "account_id", "access_token");
    }
}
