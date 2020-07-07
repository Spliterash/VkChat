package com.vk.api.sdk.queries.prettycards;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.prettycards.responses.CreateResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for PrettyCards.create method
 */
public class PrettyCardsCreateQuery extends AbstractQueryBuilder<PrettyCardsCreateQuery, CreateResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     * @param photo value of "photo" parameter.
     * @param title value of "title" parameter.
     * @param link value of "link" parameter.
     */
    public PrettyCardsCreateQuery(VkApiClient client, UserActor actor, int ownerId, String photo,
            String title, String link) {
        super(client, "prettyCards.create", CreateResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
        photo(photo);
        title(title);
        link(link);
    }

    /**
     * Set owner id
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsCreateQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set photo
     *
     * @param value value of "photo" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsCreateQuery photo(String value) {
        return unsafeParam("photo", value);
    }

    /**
     * Set title
     *
     * @param value value of "title" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsCreateQuery title(String value) {
        return unsafeParam("title", value);
    }

    /**
     * Set link
     *
     * @param value value of "link" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected PrettyCardsCreateQuery link(String value) {
        return unsafeParam("link", value);
    }

    /**
     * Set price
     *
     * @param value value of "price" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsCreateQuery price(String value) {
        return unsafeParam("price", value);
    }

    /**
     * Set price old
     *
     * @param value value of "price old" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsCreateQuery priceOld(String value) {
        return unsafeParam("price_old", value);
    }

    /**
     * Set button
     *
     * @param value value of "button" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public PrettyCardsCreateQuery button(String value) {
        return unsafeParam("button", value);
    }

    @Override
    protected PrettyCardsCreateQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("photo", "title", "owner_id", "link", "access_token");
    }
}
