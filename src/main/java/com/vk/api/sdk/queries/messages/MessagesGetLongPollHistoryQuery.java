package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.GetLongPollHistoryResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getLongPollHistory method
 */
public class MessagesGetLongPollHistoryQuery extends AbstractQueryBuilder<MessagesGetLongPollHistoryQuery, GetLongPollHistoryResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesGetLongPollHistoryQuery(VkApiClient client, UserActor actor) {
        super(client, "messages.getLongPollHistory", GetLongPollHistoryResponse.class);
        accessToken(actor.getAccessToken());
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     */
    public MessagesGetLongPollHistoryQuery(VkApiClient client, GroupActor actor) {
        super(client, "messages.getLongPollHistory", GetLongPollHistoryResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
    }

    /**
     * Last value of the 'ts' parameter returned from the Long Poll server or by using [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     *
     * @param value value of "ts" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery ts(Integer value) {
        return unsafeParam("ts", value);
    }

    /**
     * Lsat value of 'pts' parameter returned from the Long Poll server or by using [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     *
     * @param value value of "pts" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery pts(Integer value) {
        return unsafeParam("pts", value);
    }

    /**
     * Number of characters after which to truncate a previewed message. To preview the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated by words."
     *
     * @param value value of "preview length" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery previewLength(Integer value) {
        return unsafeParam("preview_length", value);
    }

    /**
     * '1' — to return history with online users only.
     *
     * @param value value of "onlines" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery onlines(Boolean value) {
        return unsafeParam("onlines", value);
    }

    /**
     * Maximum number of events to return.
     *
     * @param value value of "events limit" parameter. Minimum is 1000. By default 1000.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery eventsLimit(Integer value) {
        return unsafeParam("events_limit", value);
    }

    /**
     * Maximum number of messages to return.
     *
     * @param value value of "msgs limit" parameter. Minimum is 200. By default 200.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery msgsLimit(Integer value) {
        return unsafeParam("msgs_limit", value);
    }

    /**
     * Maximum ID of the message among existing ones in the local copy. Both messages received with API methods (for example, , ), and data received from a Long Poll server (events with code 4) are taken into account.
     *
     * @param value value of "max msg id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery maxMsgId(Integer value) {
        return unsafeParam("max_msg_id", value);
    }

    /**
     * Group ID (for group messages with user access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set lp version
     *
     * @param value value of "lp version" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery lpVersion(Integer value) {
        return unsafeParam("lp_version", value);
    }

    /**
     * Set last n
     *
     * @param value value of "last n" parameter. Maximum is 2000. Minimum is 0. By default 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery lastN(Integer value) {
        return unsafeParam("last_n", value);
    }

    /**
     * Set credentials
     *
     * @param value value of "credentials" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery credentials(Boolean value) {
        return unsafeParam("credentials", value);
    }

    /**
     * fields
     * Additional profile [vk.com/dev/fields|fields] to return.
     *
     * @param value value of "fields" parameter. By default photo,photo_medium_rec,sex,online,screen_name.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional profile [vk.com/dev/fields|fields] to return.
     *
     * @param value value of "fields" parameter. By default photo,photo_medium_rec,sex,online,screen_name.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetLongPollHistoryQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetLongPollHistoryQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("access_token");
    }
}
