package com.vk.api.sdk.objects.market.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AddResponse object
 */
public class AddResponse implements Validable {
    /**
     * Item ID
     */
    @SerializedName("market_item_id")
    private Integer marketItemId;

    public Integer getMarketItemId() {
        return marketItemId;
    }

    public AddResponse setMarketItemId(Integer marketItemId) {
        this.marketItemId = marketItemId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marketItemId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddResponse addResponse = (AddResponse) o;
        return Objects.equals(marketItemId, addResponse.marketItemId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddResponse{");
        sb.append("marketItemId=").append(marketItemId);
        sb.append('}');
        return sb.toString();
    }
}
