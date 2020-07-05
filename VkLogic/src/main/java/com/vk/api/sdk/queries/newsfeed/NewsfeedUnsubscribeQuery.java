package com.vk.api.sdk.queries.newsfeed;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.base.responses.OkResponse;
import com.vk.api.sdk.objects.enums.NewsfeedType;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Newsfeed.unsubscribe method
 */
public class NewsfeedUnsubscribeQuery extends AbstractQueryBuilder<NewsfeedUnsubscribeQuery, OkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param type value of "type" parameter.
     * @param itemId value of "item id" parameter. Minimum is 0.
     */
    public NewsfeedUnsubscribeQuery(VkApiClient client, UserActor actor, NewsfeedType type,
            int itemId) {
        super(client, "newsfeed.unsubscribe", OkResponse.class);
        accessToken(actor.getAccessToken());
        type(type);
        itemId(itemId);
    }

    /**
     * Type of object from which to unsubscribe: 'note' — note, 'photo' — photo, 'post' — post on user wall or community wall, 'topic' — topic, 'video' — video
     *
     * @param value value of "type" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected NewsfeedUnsubscribeQuery type(NewsfeedType value) {
        return unsafeParam("type", value);
    }

    /**
     * Object owner ID.
     *
     * @param value value of "owner id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public NewsfeedUnsubscribeQuery ownerId(Integer value) {
        return unsafeParam("owner_id", value);
    }

    /**
     * Object ID.
     *
     * @param value value of "item id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected NewsfeedUnsubscribeQuery itemId(int value) {
        return unsafeParam("item_id", value);
    }

    @Override
    protected NewsfeedUnsubscribeQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("item_id", "type", "access_token");
    }
}
