package com.vk.api.sdk.objects.account.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.account.Offer;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.List;
import java.util.Objects;

/**
 * GetActiveOffersResponse object
 */
public class GetActiveOffersResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Offer> items;

    public Integer getCount() {
        return count;
    }

    public GetActiveOffersResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Offer> getItems() {
        return items;
    }

    public GetActiveOffersResponse setItems(List<Offer> items) {
        this.items = items;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetActiveOffersResponse getActiveOffersResponse = (GetActiveOffersResponse) o;
        return Objects.equals(count, getActiveOffersResponse.count) &&
                Objects.equals(items, getActiveOffersResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetActiveOffersResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
