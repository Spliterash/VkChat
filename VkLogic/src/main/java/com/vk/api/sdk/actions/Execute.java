package com.vk.api.sdk.actions;

import com.vk.api.sdk.client.AbstractAction;
import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.queries.execute.ExecuteCodeQuery;

import java.util.List;

public class Execute extends AbstractAction {

    /**
     * Constructor
     *
     * @param client vk api client
     */
    public Execute(VkApiClient client) {
        super(client);
    }

    /**
     * Execute by code
     */
    public ExecuteCodeQuery code(UserActor actor, String code) {
        return new ExecuteCodeQuery(getClient(), actor, code);
    }

    /**
     * Execute by code
     */
    public ExecuteCodeQuery code(GroupActor actor, String code) {
        return new ExecuteCodeQuery(getClient(), actor, code);
    }
}
