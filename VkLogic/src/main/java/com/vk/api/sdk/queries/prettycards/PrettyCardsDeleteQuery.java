package com.vk.api.sdk.queries.prettycards;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.prettycards.responses.DeleteResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for PrettyCards.delete method
 */
public class PrettyCardsDeleteQuery extends AbstractQueryBuilder<PrettyCardsDeleteQuery, DeleteResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param cardId value of "card id" parameter.
     */
    public PrettyCardsDeleteQuery(VkApiClient client, UserActor actor, int ownerId, int cardId) {
        super(client, "prettyCards.delete", DeleteResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        cardId(cardId);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsDeleteQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set card id
     *
     * @param value value of "card id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsDeleteQuery cardId(int value) {
        return unsafeParam("card_id", value);
    }

    @Override
    protected PrettyCardsDeleteQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("card_id", "owner_id", "access_token");
    }
}
