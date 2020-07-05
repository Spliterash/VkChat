package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * JoinChatByInviteLinkResponse object
 */
public class JoinChatByInviteLinkResponse implements Validable {
    @SerializedName("chat_id")
    private Integer chatId;

    public Integer getChatId() {
        return chatId;
    }

    public JoinChatByInviteLinkResponse setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinChatByInviteLinkResponse joinChatByInviteLinkResponse = (JoinChatByInviteLinkResponse) o;
        return Objects.equals(chatId, joinChatByInviteLinkResponse.chatId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("JoinChatByInviteLinkResponse{");
        sb.append("chatId=").append(chatId);
        sb.append('}');
        return sb.toString();
    }
}
