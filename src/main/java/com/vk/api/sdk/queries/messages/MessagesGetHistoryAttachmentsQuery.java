package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.enums.MessagesMediaType;
import com.vk.api.sdk.objects.messages.responses.GetHistoryAttachmentsResponse;
import com.vk.api.sdk.objects.users.Fields;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getHistoryAttachments method
 */
public class MessagesGetHistoryAttachmentsQuery extends AbstractQueryBuilder<MessagesGetHistoryAttachmentsQuery, GetHistoryAttachmentsResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     */
    public MessagesGetHistoryAttachmentsQuery(VkApiClient client, UserActor actor, int peerId) {
        super(client, "messages.getHistoryAttachments", GetHistoryAttachmentsResponse.class);
        accessToken(actor.getAccessToken());
        peerId(peerId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter.
     */
    public MessagesGetHistoryAttachmentsQuery(VkApiClient client, GroupActor actor, int peerId) {
        super(client, "messages.getHistoryAttachments", GetHistoryAttachmentsResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        peerId(peerId);
    }

    /**
     * Peer ID. ", For group chat: '2000000000 + chat ID' , , For community: '-community ID'"
     *
     * @param value value of "peer id" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetHistoryAttachmentsQuery peerId(int value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * Type of media files to return: *'photo',, *'video',, *'audio',, *'doc',, *'link'.,*'market'.,*'wall'.,*'share'
     *
     * @param value value of "media type" parameter. By default photo.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery mediaType(MessagesMediaType value) {
        return unsafeParam("media_type", value);
    }

    /**
     * Message ID to start return results from.
     *
     * @param value value of "start from" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery startFrom(String value) {
        return unsafeParam("start_from", value);
    }

    /**
     * Number of objects to return.
     *
     * @param value value of "count" parameter. Maximum is 200. Minimum is 0. By default 30.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery count(Integer value) {
        return unsafeParam("count", value);
    }

    /**
     * '1' — to return photo sizes in a
     *
     * @param value value of "photo sizes" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery photoSizes(Boolean value) {
        return unsafeParam("photo_sizes", value);
    }

    /**
     * Group ID (for group messages with group access token)
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    /**
     * Set preserve order
     *
     * @param value value of "preserve order" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery preserveOrder(Boolean value) {
        return unsafeParam("preserve_order", value);
    }

    /**
     * Set max forwards level
     *
     * @param value value of "max forwards level" parameter. Maximum is 45. Minimum is 0. By default 45.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery maxForwardsLevel(Integer value) {
        return unsafeParam("max_forwards_level", value);
    }

    /**
     * fields
     * Additional profile [vk.com/dev/fields|fields] to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery fields(Fields... value) {
        return unsafeParam("fields", value);
    }

    /**
     * Additional profile [vk.com/dev/fields|fields] to return.
     *
     * @param value value of "fields" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetHistoryAttachmentsQuery fields(List<Fields> value) {
        return unsafeParam("fields", value);
    }

    @Override
    protected MessagesGetHistoryAttachmentsQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("peer_id", "access_token");
    }
}
