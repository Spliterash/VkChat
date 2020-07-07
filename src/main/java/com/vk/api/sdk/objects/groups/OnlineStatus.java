package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Online status of group
 */
public class OnlineStatus implements Validable {
    /**
     * Estimated time of answer (for status = answer_mark)
     */
    @SerializedName("minutes")
    private Integer minutes;

    @SerializedName("status")
    @Required
    private OnlineStatusType status;

    public Integer getMinutes() {
        return minutes;
    }

    public OnlineStatus setMinutes(Integer minutes) {
        this.minutes = minutes;
        return this;
    }

    public OnlineStatusType getStatus() {
        return status;
    }

    public OnlineStatus setStatus(OnlineStatusType status) {
        this.status = status;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineStatus onlineStatus = (OnlineStatus) o;
        return Objects.equals(minutes, onlineStatus.minutes) &&
                Objects.equals(status, onlineStatus.status);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("OnlineStatus{");
        sb.append("minutes=").append(minutes);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
