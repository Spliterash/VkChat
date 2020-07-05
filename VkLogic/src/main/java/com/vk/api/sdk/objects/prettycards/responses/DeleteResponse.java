package com.vk.api.sdk.objects.prettycards.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * DeleteResponse object
 */
public class DeleteResponse implements Validable {
    /**
     * Owner ID of deleted pretty card
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Card ID of deleted pretty card
     */
    @SerializedName("card_id")
    private String cardId;

    /**
     * Error reason if error happened
     */
    @SerializedName("error")
    private String error;

    public Integer getOwnerId() {
        return ownerId;
    }

    public DeleteResponse setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public DeleteResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getError() {
        return error;
    }

    public DeleteResponse setError(String error) {
        this.error = error;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, ownerId, error);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteResponse deleteResponse = (DeleteResponse) o;
        return Objects.equals(ownerId, deleteResponse.ownerId) &&
                Objects.equals(error, deleteResponse.error) &&
                Objects.equals(cardId, deleteResponse.cardId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DeleteResponse{");
        sb.append("ownerId=").append(ownerId);
        sb.append(", error='").append(error).append("'");
        sb.append(", cardId='").append(cardId).append("'");
        sb.append('}');
        return sb.toString();
    }
}
