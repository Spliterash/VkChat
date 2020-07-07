package com.vk.api.sdk.objects.database.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.database.Station;
import java.util.List;
import java.util.Objects;

/**
 * GetMetroStationsResponse object
 */
public class GetMetroStationsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Station> items;

    public Integer getCount() {
        return count;
    }

    public GetMetroStationsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Station> getItems() {
        return items;
    }

    public GetMetroStationsResponse setItems(List<Station> items) {
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
        GetMetroStationsResponse getMetroStationsResponse = (GetMetroStationsResponse) o;
        return Objects.equals(count, getMetroStationsResponse.count) &&
                Objects.equals(items, getMetroStationsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetMetroStationsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
