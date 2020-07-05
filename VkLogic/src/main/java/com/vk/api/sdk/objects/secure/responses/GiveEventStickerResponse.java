package com.vk.api.sdk.objects.secure.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * GiveEventStickerResponse object
 */
public class GiveEventStickerResponse implements Validable {
    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("status")
    private String status;

    public Integer getUserId() {
        return userId;
    }

    public GiveEventStickerResponse setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public GiveEventStickerResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiveEventStickerResponse giveEventStickerResponse = (GiveEventStickerResponse) o;
        return Objects.equals(userId, giveEventStickerResponse.userId) &&
                Objects.equals(status, giveEventStickerResponse.status);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GiveEventStickerResponse{");
        sb.append("userId=").append(userId);
        sb.append(", status='").append(status).append("'");
        sb.append('}');
        return sb.toString();
    }
}
