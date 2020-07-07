package com.vk.api.sdk.objects.prettycards.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * EditResponse object
 */
public class EditResponse implements Validable {
    /**
     * Owner ID of edited pretty card
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Card ID of edited pretty card
     */
    @SerializedName("card_id")
    private String cardId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public EditResponse setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public EditResponse setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, ownerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditResponse editResponse = (EditResponse) o;
        return Objects.equals(ownerId, editResponse.ownerId) &&
                Objects.equals(cardId, editResponse.cardId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("EditResponse{");
        sb.append("ownerId=").append(ownerId);
        sb.append(", cardId='").append(cardId).append("'");
        sb.append('}');
        return sb.toString();
    }
}
