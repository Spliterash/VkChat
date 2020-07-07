package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * MessageDeny object
 */
public class MessageDeny implements Validable {
    @SerializedName("user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public MessageDeny setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDeny messageDeny = (MessageDeny) o;
        return Objects.equals(userId, messageDeny.userId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MessageDeny{");
        sb.append("userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
