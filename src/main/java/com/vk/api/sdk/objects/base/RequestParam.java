package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * RequestParam object
 */
public class RequestParam implements Validable {
    /**
     * Parameter name
     */
    @SerializedName("key")
    private String key;

    /**
     * Parameter value
     */
    @SerializedName("value")
    private String value;

    public String getKey() {
        return key;
    }

    public RequestParam setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public RequestParam setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestParam requestParam = (RequestParam) o;
        return Objects.equals(value, requestParam.value) &&
                Objects.equals(key, requestParam.key);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("RequestParam{");
        sb.append("value='").append(value).append("'");
        sb.append(", key='").append(key).append("'");
        sb.append('}');
        return sb.toString();
    }
}
