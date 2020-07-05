package com.vk.api.sdk.objects.friends.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * GetOnlineOnlineMobileResponse object
 */
public class GetOnlineOnlineMobileResponse implements Validable {
    @SerializedName("online")
    private List<Integer> online;

    @SerializedName("online_mobile")
    private List<Integer> onlineMobile;

    public List<Integer> getOnline() {
        return online;
    }

    public GetOnlineOnlineMobileResponse setOnline(List<Integer> online) {
        this.online = online;
        return this;
    }

    public List<Integer> getOnlineMobile() {
        return onlineMobile;
    }

    public GetOnlineOnlineMobileResponse setOnlineMobile(List<Integer> onlineMobile) {
        this.onlineMobile = onlineMobile;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(online, onlineMobile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOnlineOnlineMobileResponse getOnlineOnlineMobileResponse = (GetOnlineOnlineMobileResponse) o;
        return Objects.equals(onlineMobile, getOnlineOnlineMobileResponse.onlineMobile) &&
                Objects.equals(online, getOnlineOnlineMobileResponse.online);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetOnlineOnlineMobileResponse{");
        sb.append("onlineMobile=").append(onlineMobile);
        sb.append(", online=").append(online);
        sb.append('}');
        return sb.toString();
    }
}
