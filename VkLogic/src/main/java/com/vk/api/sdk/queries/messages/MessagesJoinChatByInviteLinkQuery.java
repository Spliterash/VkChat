package com.vk.api.sdk.queries.messages;

import com.vk.api.sdk.client.AbstractQueryBuilder;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.objects.messages.responses.JoinChatByInviteLinkResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Query for Messages.joinChatByInviteLink method
 */
public class MessagesJoinChatByInviteLinkQuery extends AbstractQueryBuilder<MessagesJoinChatByInviteLinkQuery, JoinChatByInviteLinkResponse> {
    /**
     * Creates a AbstractQueryBuilder instance that can be used to build api request with various parameters
     *
     * @param client VK API client
     * @param actor actor with access token
     * @param link value of "link" parameter.
     */
    public MessagesJoinChatByInviteLinkQuery(VkApiClient client, UserActor actor, String link) {
        super(client, "messages.joinChatByInviteLink", JoinChatByInviteLinkResponse.class);
        accessToken(actor.getAccessToken());
        link(link);
    }

    /**
     * Invitation link.
     *
     * @param value value of "link" parameter.
     * @return a reference to this {@code AbstractQueryBuilder} object to fulfill the "Builder" pattern.
     */
    protected MessagesJoinChatByInviteLinkQuery link(String value) {
        return unsafeParam("link", value);
    }

    @Override
    protected MessagesJoinChatByInviteLinkQuery getThis() {
        return this;
    }

    @Override
    protected List<String> essentialKeys() {
        return Arrays.asList("link", "access_token");
    }
}
