package com.vk.api.sdk.objects.storage;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Value object
 */
public class Value implements Validable {
    @SerializedName("key")
    @Required
    private String key;

    @SerializedName("value")
    @Required
    private String value;

    public String getKey() {
        return key;
    }

    public Value setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Value setValue(String value) {
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
        Value value = (Value) o;
        return Objects.equals(value, value.value) &&
                Objects.equals(key, value.key);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Value{");
        sb.append("value='").append(value).append("'");
        sb.append(", key='").append(key).append("'");
        sb.append('}');
        return sb.toString();
    }
}
