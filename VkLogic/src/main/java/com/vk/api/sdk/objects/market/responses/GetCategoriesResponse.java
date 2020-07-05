package com.vk.api.sdk.objects.market.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.market.MarketCategory;
import java.util.List;
import java.util.Objects;

/**
 * GetCategoriesResponse object
 */
public class GetCategoriesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<MarketCategory> items;

    public Integer getCount() {
        return count;
    }

    public GetCategoriesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<MarketCategory> getItems() {
        return items;
    }

    public GetCategoriesResponse setItems(List<MarketCategory> items) {
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
        GetCategoriesResponse getCategoriesResponse = (GetCategoriesResponse) o;
        return Objects.equals(count, getCategoriesResponse.count) &&
                Objects.equals(items, getCategoriesResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCategoriesResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
