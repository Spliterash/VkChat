package com.vk.api.sdk.queries.secure;

import com.vk.api.sdk.client.AbstractSecureQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.objects.secure.responses.GiveEventStickerResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Secure.giveEventSticker method
 */
public class SecureGiveEventStickerQuery extends AbstractSecureQueryBuilder<SecureGiveEventStickerQuery, List<GiveEventStickerResponse>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param achievementId value of "achievement id" parameter. Minimum is 0.
     * @param userIds value of "user ids" parameter.
     */
    public SecureGiveEventStickerQuery(VkApiClient client, ServiceActor actor, int achievementId,
            Integer... userIds) {
        super(client, "secure.giveEventSticker", Utils.buildParametrizedType(List.class, GiveEventStickerResponse.class));
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        achievementId(achievementId);
        userIds(userIds);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param achievementId value of "achievement id" parameter. Minimum is 0.
     * @param userIds value of "user ids" parameter.
     */
    public SecureGiveEventStickerQuery(VkApiClient client, ServiceActor actor, int achievementId,
            List<Integer> userIds) {
        super(client, "secure.giveEventSticker", Utils.buildParametrizedType(List.class, GiveEventStickerResponse.class));
        accessToken(actor.getAccessToken());
        clientSecret(actor.getClientSecret());
        achievementId(achievementId);
        userIds(userIds);
    }

    /**
     * Set achievement id
     *
     * @param value value of "achievement id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected SecureGiveEventStickerQuery achievementId(int value) {
        return unsafeParam("achievement_id", value);
    }

    /**
     * user_ids
     * Set user ids
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected SecureGiveEventStickerQuery userIds(Integer... value) {
        return unsafeParam("user_ids", value);
    }

    /**
     * Set user ids
     *
     * @param value value of "user ids" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected SecureGiveEventStickerQuery userIds(List<Integer> value) {
        return unsafeParam("user_ids", value);
    }

    @Override
    protected SecureGiveEventStickerQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("user_ids", "achievement_id", "access_token");
    }
}
