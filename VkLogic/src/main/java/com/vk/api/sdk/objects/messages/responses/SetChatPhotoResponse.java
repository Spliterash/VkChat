package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.messages.Chat;
import java.util.Objects;

/**
 * SetChatPhotoResponse object
 */
public class SetChatPhotoResponse implements Validable {
    /**
     * Service message ID
     */
    @SerializedName("message_id")
    private Integer messageId;

    @SerializedName("chat")
    private Chat chat;

    public Integer getMessageId() {
        return messageId;
    }

    public SetChatPhotoResponse setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Chat getChat() {
        return chat;
    }

    public SetChatPhotoResponse setChat(Chat chat) {
        this.chat = chat;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, messageId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetChatPhotoResponse setChatPhotoResponse = (SetChatPhotoResponse) o;
        return Objects.equals(chat, setChatPhotoResponse.chat) &&
                Objects.equals(messageId, setChatPhotoResponse.messageId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SetChatPhotoResponse{");
        sb.append("chat=").append(chat);
        sb.append(", messageId=").append(messageId);
        sb.append('}');
        return sb.toString();
    }
}
