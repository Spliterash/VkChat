package com.vk.api.sdk.objects.notifications;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * SendMessageError object
 */
public class SendMessageError implements Validable {
    /**
     * Error code
     */
    @SerializedName("code")
    private SendMessageErrorCode code;

    /**
     * Error description
     */
    @SerializedName("description")
    private String description;

    public SendMessageErrorCode getCode() {
        return code;
    }

    public SendMessageError setCode(SendMessageErrorCode code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SendMessageError setDescription(String description) {
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
        SendMessageError sendMessageError = (SendMessageError) o;
        return Objects.equals(code, sendMessageError.code) &&
                Objects.equals(description, sendMessageError.description);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SendMessageError{");
        sb.append("code=").append(code);
        sb.append(", description='").append(description).append("'");
        sb.append('}');
        return sb.toString();
    }
}
