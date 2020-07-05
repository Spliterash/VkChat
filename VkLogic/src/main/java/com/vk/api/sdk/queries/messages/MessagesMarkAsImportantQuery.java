package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.Utils;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.markAsImportant method
 */
public class MessagesMarkAsImportantQuery extends AbstractQueryBuilder<MessagesMarkAsImportantQuery, List<Integer>> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesMarkAsImportantQuery(VkApiClient client, UserActor actor) {
        super(client, "messages.markAsImportant", Utils.buildParametrizedType(List.class, Integer.class));
        accessToken(actor.getAccessToken());
    }

    /**
     * '1' — to add a star (mark as important), '0' — to remove the star
     *
     * @param value value of "important" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesMarkAsImportantQuery important(Integer value) {
        return unsafeParam("important", value);
    }

    /**
     * message_ids
     * IDs of messages to mark as important.
     *
     * @param value value of "message ids" parameter. By default [].
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesMarkAsImportantQuery messageIds(Integer... value) {
        return unsafeParam("message_ids", value);
    }

    /**
     * IDs of messages to mark as important.
     *
     * @param value value of "message ids" parameter. By default [].
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesMarkAsImportantQuery messageIds(List<Integer> value) {
        return unsafeParam("message_ids", value);
    }

    @Override
    protected MessagesMarkAsImportantQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
