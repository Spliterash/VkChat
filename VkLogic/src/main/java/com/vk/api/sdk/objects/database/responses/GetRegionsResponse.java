package com.vk.api.sdk.objects.database.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.database.Region;
import java.util.List;
import java.util.Objects;

/**
 * GetRegionsResponse object
 */
public class GetRegionsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Region> items;

    public Integer getCount() {
        return count;
    }

    public GetRegionsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Region> getItems() {
        return items;
    }

    public GetRegionsResponse setItems(List<Region> items) {
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
        GetRegionsResponse getRegionsResponse = (GetRegionsResponse) o;
        return Objects.equals(count, getRegionsResponse.count) &&
                Objects.equals(items, getRegionsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetRegionsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
