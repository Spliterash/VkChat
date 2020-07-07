package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * MessageAction object
 */
public class MessageAction implements Validable {
    /**
     * Message ID
     */
    @SerializedName("conversation_message_id")
    private Integer conversationMessageId;

    /**
     * Email address for chat_invite_user or chat_kick_user actions
     */
    @SerializedName("email")
    private String email;

    /**
     * User or email peer ID
     */
    @SerializedName("member_id")
    private Integer memberId;

    /**
     * Message body of related message
     */
    @SerializedName("message")
    private String message;

    @SerializedName("photo")
    private MessageActionPhoto photo;

    /**
     * New chat title for chat_create and chat_title_update actions
     */
    @SerializedName("text")
    private String text;

    @SerializedName("type")
    @Required
    private MessageActionStatus type;

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public MessageAction setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MessageAction setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public MessageAction setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageAction setMessage(String message) {
        this.message = message;
        return this;
    }

    public MessageActionPhoto getPhoto() {
        return photo;
    }

    public MessageAction setPhoto(MessageActionPhoto photo) {
        this.photo = photo;
        return this;
    }

    public String getText() {
        return text;
    }

    public MessageAction setText(String text) {
        this.text = text;
        return this;
    }

    public MessageActionStatus getType() {
        return type;
    }

    public MessageAction setType(MessageActionStatus type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conversationMessageId, photo, text, message, type, email, memberId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageAction messageAction = (MessageAction) o;
        return Objects.equals(memberId, messageAction.memberId) &&
                Objects.equals(photo, messageAction.photo) &&
                Objects.equals(text, messageAction.text) &&
                Objects.equals(message, messageAction.message) &&
                Objects.equals(type, messageAction.type) &&
                Objects.equals(email, messageAction.email) &&
                Objects.equals(conversationMessageId, messageAction.conversationMessageId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MessageAction{");
        sb.append("memberId=").append(memberId);
        sb.append(", photo=").append(photo);
        sb.append(", text='").append(text).append("'");
        sb.append(", message='").append(message).append("'");
        sb.append(", type=").append(type);
        sb.append(", email='").append(email).append("'");
        sb.append(", conversationMessageId=").append(conversationMessageId);
        sb.append('}');
        return sb.toString();
    }
}
