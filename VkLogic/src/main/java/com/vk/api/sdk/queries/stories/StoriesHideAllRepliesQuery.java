package com.vk.api.sdk.queries.stories;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Stories.hideAllReplies method
 */
public class StoriesHideAllRepliesQuery extends AbstractQueryBuilder<StoriesHideAllRepliesQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     */
    public StoriesHideAllRepliesQuery(VkApiClient client, UserActor actor, int ownerId) {
        super(client, "stories.hideAllReplies", OkResponse.class);
        accessToken(actor.getAccessToken());
        ownerId(ownerId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param ownerId value of "owner id" parameter.
     */
    public StoriesHideAllRepliesQuery(VkApiClient client, GroupActor actor, int ownerId) {
        super(client, "stories.hideAllReplies", OkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        ownerId(ownerId);
    }

    /**
     * ID of the user whose replies should be hidden.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected StoriesHideAllRepliesQuery ownerId(int value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Set group id
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public StoriesHideAllRepliesQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected StoriesHideAllRepliesQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("owner_id", "access_token");
    }
}
