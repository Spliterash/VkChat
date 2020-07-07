package com.vk.api.sdk.objects.friends;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Requests object
 */
public class Requests implements Validable {
    /**
     * ID of the user by whom friend has been suggested
     */
    @SerializedName("from")
    private String from;

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

    public Requests setFrom(String from) {
        this.from = from;
        return this;
    }

    public RequestsMutual getMutual() {
        return mutual;
    }

    public Requests setMutual(RequestsMutual mutual) {
        this.mutual = mutual;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Requests setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mutual, from, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requests requests = (Requests) o;
        return Objects.equals(mutual, requests.mutual) &&
                Objects.equals(userId, requests.userId) &&
                Objects.equals(from, requests.from);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Requests{");
        sb.append("mutual=").append(mutual);
        sb.append(", userId=").append(userId);
        sb.append(", from='").append(from).append("'");
        sb.append('}');
        return sb.toString();
    }
}
