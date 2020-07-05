package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.widgets.WidgetsGetCommentsQuery;
import com.vk.api.sdk.queries.widgets.WidgetsGetPagesQuery;

/**
 * List of Widgets methods
 */
public class Widgets extends AbstractAction {
    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Widgets(VkApiClient client) {
        super(client);
    }

    /**
     * Gets a list of comments for the page added through the [vk.com/dev/Comments|Comments widget].
     *
     * @param actor vk actor
     * @return query
     */
    public WidgetsGetCommentsQuery getComments(UserActor actor) {
        return new WidgetsGetCommentsQuery(getClient(), actor);
    }

    /**
     * Gets a list of comments for the page added through the [vk.com/dev/Comments|Comments widget].
     *
     * @param actor vk actor
     * @return query
     */
    public WidgetsGetCommentsQuery getComments(ServiceActor actor) {
        return new WidgetsGetCommentsQuery(getClient(), actor);
    }

    /**
     * Gets a list of application/site pages where the [vk.com/dev/Comments|Comments widget] or [vk.com/dev/Like|Like widget] is installed.
     *
     * @param actor vk actor
     * @return query
     */
    public WidgetsGetPagesQuery getPages(UserActor actor) {
        return new WidgetsGetPagesQuery(getClient(), actor);
    }

    /**
     * Gets a list of application/site pages where the [vk.com/dev/Comments|Comments widget] or [vk.com/dev/Like|Like widget] is installed.
     *
     * @param actor vk actor
     * @return query
     */
    public WidgetsGetPagesQuery getPages(ServiceActor actor) {
        return new WidgetsGetPagesQuery(getClient(), actor);
    }
}
