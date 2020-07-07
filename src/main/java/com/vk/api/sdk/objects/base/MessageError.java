package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * MessageError object
 */
public class MessageError implements Validable {
    /**
     * Error code
     */
    @SerializedName("code")
    private Integer code;

    /**
     * Error message
     */
    @SerializedName("description")
    private String description;

    public Integer getCode() {
        return code;
    }

    public MessageError setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MessageError setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageError messageError = (MessageError) o;
        return Objects.equals(code, messageError.code) &&
                Objects.equals(description, messageError.description);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MessageError{");
        sb.append("code=").append(code);
        sb.append(", description='").append(description).append("'");
        sb.append('}');
        return sb.toString();
    }
}
