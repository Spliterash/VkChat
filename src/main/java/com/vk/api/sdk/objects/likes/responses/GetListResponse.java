package com.vk.api.sdk.objects.likes.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.List;
import java.util.Objects;

/**
 * GetListResponse object
 */
public class GetListResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Integer> items;

    public Integer getCount() {
        return count;
    }

    public GetListResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Integer> getItems() {
        return items;
    }

    public GetListResponse setItems(List<Integer> items) {
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
        GetListResponse getListResponse = (GetListResponse) o;
        return Objects.equals(count, getListResponse.count) &&
                Objects.equals(items, getListResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetListResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
