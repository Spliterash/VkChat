package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * ConversationWithMessage object
 */
public class ConversationWithMessage implements Validable {
    @SerializedName("conversation")
    private Conversation conversation;

    @SerializedName("last_message")
    private Message lastMessage;

    public Conversation getConversation() {
        return conversation;
    }

    public ConversationWithMessage setConversation(Conversation conversation) {
        this.conversation = conversation;
        return this;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public ConversationWithMessage setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastMessage, conversation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationWithMessage conversationWithMessage = (ConversationWithMessage) o;
        return Objects.equals(lastMessage, conversationWithMessage.lastMessage) &&
                Objects.equals(conversation, conversationWithMessage.conversation);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ConversationWithMessage{");
        sb.append("lastMessage=").append(lastMessage);
        sb.append(", conversation=").append(conversation);
        sb.append('}');
        return sb.toString();
    }
}
