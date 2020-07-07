package com.vk.api.sdk.objects.prettycards.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * CreateResponse object
 */
public class CreateResponse implements Validable {
    /**
     * Owner ID of created pretty card
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Card ID of created pretty card
     */
    @SerializedName("card_id")
    private String cardId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public CreateResponse setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public CreateResponse setCardId(String cardId) {
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
        CreateResponse createResponse = (CreateResponse) o;
        return Objects.equals(ownerId, createResponse.ownerId) &&
                Objects.equals(cardId, createResponse.cardId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CreateResponse{");
        sb.append("ownerId=").append(ownerId);
        sb.append(", cardId='").append(cardId).append("'");
        sb.append('}');
        return sb.toString();
    }
}
