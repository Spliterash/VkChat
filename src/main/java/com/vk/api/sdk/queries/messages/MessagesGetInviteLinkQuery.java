package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.GetInviteLinkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.getInviteLink method
 */
public class MessagesGetInviteLinkQuery extends AbstractQueryBuilder<MessagesGetInviteLinkQuery, GetInviteLinkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter. Minimum is 0.
     */
    public MessagesGetInviteLinkQuery(VkApiClient client, UserActor actor, int peerId) {
        super(client, "messages.getInviteLink", GetInviteLinkResponse.class);
        accessToken(actor.getAccessToken());
        peerId(peerId);
    }

    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param peerId value of "peer id" parameter. Minimum is 0.
     */
    public MessagesGetInviteLinkQuery(VkApiClient client, GroupActor actor, int peerId) {
        super(client, "messages.getInviteLink", GetInviteLinkResponse.class);
        accessToken(actor.getAccessToken());
        groupId(actor.getGroupId());
        peerId(peerId);
    }

    /**
     * Destination ID.
     *
     * @param value value of "peer id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesGetInviteLinkQuery peerId(int value) {
        return unsafeParam("peer_id", value);
    }

    /**
     * 1 — to generate new link (revoke previous), 0 — to return previous link.
     *
     * @param value value of "reset" parameter. By default false.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetInviteLinkQuery reset(Boolean value) {
        return unsafeParam("reset", value);
    }

    /**
     * Group ID
     *
     * @param value value of "group id" parameter. Minimum is 0.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    public MessagesGetInviteLinkQuery groupId(Integer value) {
        return unsafeParam("group_id", value);
    }

    @Override
    protected MessagesGetInviteLinkQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("peer_id", "access_token");
    }
}
