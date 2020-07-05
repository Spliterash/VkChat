package com.vk.api.sdk.objects.friends;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * RequestsXtrMessage object
 */
public class RequestsXtrMessage implements Validable {
    /**
     * ID of the user by whom friend has been suggested
     */
    @SerializedName("from")
    private String from;

    /**
     * Message sent with a request
     */
    @SerializedName("message")
    private String message;

    @SerializedName("mutual")
    private RequestsMutual mutual;

    /**
     * User ID
     */
    @SerializedName("user_id")
    private Integer userId;

    public String getFrom() {
        return from;
    }

    public RequestsXtrMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RequestsXtrMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public RequestsMutual getMutual() {
        return mutual;
    }

    public RequestsXtrMessage setMutual(RequestsMutual mutual) {
        this.mutual = mutual;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public RequestsXtrMessage setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mutual, from, message, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestsXtrMessage requestsXtrMessage = (RequestsXtrMessage) o;
        return Objects.equals(mutual, requestsXtrMessage.mutual) &&
                Objects.equals(userId, requestsXtrMessage.userId) &&
                Objects.equals(from, requestsXtrMessage.from) &&
                Objects.equals(message, requestsXtrMessage.message);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("RequestsXtrMessage{");
        sb.append("mutual=").append(mutual);
        sb.append(", userId=").append(userId);
        sb.append(", from='").append(from).append("'");
        sb.append(", message='").append(message).append("'");
        sb.append('}');
        return sb.toString();
    }
}
