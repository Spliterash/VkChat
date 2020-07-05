package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * DeleteConversationResponse object
 */
public class DeleteConversationResponse implements Validable {
    /**
     * Id of the last message, that was deleted
     */
    @SerializedName("last_deleted_id")
    private Integer lastDeletedId;

    public Integer getLastDeletedId() {
        return lastDeletedId;
    }

    public DeleteConversationResponse setLastDeletedId(Integer lastDeletedId) {
        this.lastDeletedId = lastDeletedId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastDeletedId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteConversationResponse deleteConversationResponse = (DeleteConversationResponse) o;
        return Objects.equals(lastDeletedId, deleteConversationResponse.lastDeletedId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DeleteConversationResponse{");
        sb.append("lastDeletedId=").append(lastDeletedId);
        sb.append('}');
        return sb.toString();
    }
}
