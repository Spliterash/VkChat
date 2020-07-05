package com.vk.api.sdk.objects.database.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.base.BaseObject;
import java.util.List;
import java.util.Objects;

/**
 * GetChairsResponse object
 */
public class GetChairsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<BaseObject> items;

    public Integer getCount() {
        return count;
    }

    public GetChairsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<BaseObject> getItems() {
        return items;
    }

    public GetChairsResponse setItems(List<BaseObject> items) {
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
        GetChairsResponse getChairsResponse = (GetChairsResponse) o;
        return Objects.equals(count, getChairsResponse.count) &&
                Objects.equals(items, getChairsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetChairsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
