package com.vk.api.sdk.queries.prettycards;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.prettycards.responses.EditResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for PrettyCards.edit method
 */
public class PrettyCardsEditQuery extends AbstractQueryBuilder<PrettyCardsEditQuery, EditResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param cardId value of "card id" parameter.
     */
    public PrettyCardsEditQuery(VkApiClient client, UserActor actor, int ownerId, int cardId) {
        super(client, "prettyCards.edit", EditResponse.class);
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
    protected PrettyCardsEditQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set card id
     *
     * @param value value of "card id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsEditQuery cardId(int value) {
        return unsafeParam("card_id", value);
    }

    /**
     * Set photo
     *
     * @param value value of "photo" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery photo(String value) {
        return unsafeParam("photo", value);
    }

    /**
     * Set title
     *
     * @param value value of "title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery title(String value) {
        return unsafeParam("title", value);
    }

    /**
     * Set link
     *
     * @param value value of "link" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery link(String value) {
        return unsafeParam("link", value);
    }

    /**
     * Set price
     *
     * @param value value of "price" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery price(String value) {
        return unsafeParam("price", value);
    }

    /**
     * Set price old
     *
     * @param value value of "price old" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery priceOld(String value) {
        return unsafeParam("price_old", value);
    }

    /**
     * Set button
     *
     * @param value value of "button" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsEditQuery button(String value) {
        return unsafeParam("button", value);
    }

    @Override
    protected PrettyCardsEditQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("card_id", "owner_id", "access_token");
    }
}
