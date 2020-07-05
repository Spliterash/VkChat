package com.vk.api.sdk.objects.groups.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AddCallbackServerResponse object
 */
public class AddCallbackServerResponse implements Validable {
    @SerializedName("server_id")
    private Integer serverId;

    public Integer getServerId() {
        return serverId;
    }

    public AddCallbackServerResponse setServerId(Integer serverId) {
        this.serverId = serverId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCallbackServerResponse addCallbackServerResponse = (AddCallbackServerResponse) o;
        return Objects.equals(serverId, addCallbackServerResponse.serverId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddCallbackServerResponse{");
        sb.append("serverId=").append(serverId);
        sb.append('}');
        return sb.toString();
    }
}
