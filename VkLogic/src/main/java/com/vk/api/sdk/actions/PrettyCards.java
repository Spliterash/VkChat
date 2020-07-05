package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.prettycards.PrettyCardsCreateQuery;
import com.vk.api.sdk.queries.prettycards.PrettyCardsDeleteQuery;
import com.vk.api.sdk.queries.prettycards.PrettyCardsEditQuery;
import com.vk.api.sdk.queries.prettycards.PrettyCardsGetByIdQuery;
import com.vk.api.sdk.queries.prettycards.PrettyCardsGetQuery;
import com.vk.api.sdk.queries.prettycards.PrettyCardsGetUploadURLQuery;
import java.util.List;

/**
 * List of PrettyCards methods
 */
public class PrettyCards extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public PrettyCards(VkApiClient client) {
        super(client);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @param photo
     * @param title
     * @param link
     * @return query
     */
    public PrettyCardsCreateQuery create(UserActor actor, int ownerId, String photo, String title,
            String link) {
        return new PrettyCardsCreateQuery(getClient(), actor, ownerId, photo, title, link);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @param cardId
     * @return query
     */
    public PrettyCardsDeleteQuery delete(UserActor actor, int ownerId, int cardId) {
        return new PrettyCardsDeleteQuery(getClient(), actor, ownerId, cardId);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @param cardId
     * @return query
     */
    public PrettyCardsEditQuery edit(UserActor actor, int ownerId, int cardId) {
        return new PrettyCardsEditQuery(getClient(), actor, ownerId, cardId);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @return query
     */
    public PrettyCardsGetQuery get(UserActor actor, int ownerId) {
        return new PrettyCardsGetQuery(getClient(), actor, ownerId);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @param cardIds
     * @return query
     */
    public PrettyCardsGetByIdQuery getById(UserActor actor, int ownerId, Integer... cardIds) {
        return new PrettyCardsGetByIdQuery(getClient(), actor, ownerId, cardIds);
    }

    /**
     * @param actor vk actor
     * @param ownerId
     * @param cardIds
     * @return query
     */
    public PrettyCardsGetByIdQuery getById(UserActor actor, int ownerId, List<Integer> cardIds) {
        return new PrettyCardsGetByIdQuery(getClient(), actor, ownerId, cardIds);
    }

    /**
     * @param actor vk actor
     * @return query
     */
    public PrettyCardsGetUploadURLQuery getUploadURL(UserActor actor) {
        return new PrettyCardsGetUploadURLQuery(getClient(), actor);
    }
}
