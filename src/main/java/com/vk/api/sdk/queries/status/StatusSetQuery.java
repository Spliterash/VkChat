package com.vk.api.sdk.queries.status;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Status.set method
 */
public class StatusSetQuery extends AbstractQueryBuilder<StatusSetQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public StatusSetQuery(VkApiClient client, UserActor actor) {
        super(client, "status.set", OkResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Text of the new status.
     *
     * @param value value of "text" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StatusSetQuery text(String value) {
        return unsafeParam("text", value);
    }

    /**
     * Identifier of a community to set a status in. If left blank the status is set to current user.
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StatusSetQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected StatusSetQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
