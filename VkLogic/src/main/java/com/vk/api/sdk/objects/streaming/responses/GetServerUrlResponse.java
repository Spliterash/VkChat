package com.vk.api.sdk.objects.streaming.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * GetServerUrlResponse object
 */
public class GetServerUrlResponse implements Validable {
    /**
     * Server host
     */
    @SerializedName("endpoint")
    private String endpoint;

    /**
     * Access key
     */
    @SerializedName("key")
    private String key;

    public String getEndpoint() {
        return endpoint;
    }

    public GetServerUrlResponse setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getKey() {
        return key;
    }

    public GetServerUrlResponse setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endpoint, key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetServerUrlResponse getServerUrlResponse = (GetServerUrlResponse) o;
        return Objects.equals(endpoint, getServerUrlResponse.endpoint) &&
                Objects.equals(key, getServerUrlResponse.key);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetServerUrlResponse{");
        sb.append("endpoint='").append(endpoint).append("'");
        sb.append(", key='").append(key).append("'");
        sb.append('}');
        return sb.toString();
    }
}
