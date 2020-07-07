package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.status.StatusGetQuery;
import com.vk.api.sdk.queries.status.StatusSetQuery;

/**
 * List of Status methods
 */
public class Status extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Status(VkApiClient client) {
        super(client);
    }

    /**
     * Returns data required to show the status of a user or community.
     *
     * @param actor vk actor
     * @return query
     */
    public StatusGetQuery get(UserActor actor) {
        return new StatusGetQuery(getClient(), actor);
    }

    /**
     * Sets a new status for the current user.
     *
     * @param actor vk actor
     * @return query
     */
    public StatusSetQuery set(UserActor actor) {
        return new StatusSetQuery(getClient(), actor);
    }
}
