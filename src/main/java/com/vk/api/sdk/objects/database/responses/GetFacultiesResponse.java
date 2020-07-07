package com.vk.api.sdk.objects.database.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.database.Faculty;
import java.util.List;
import java.util.Objects;

/**
 * GetFacultiesResponse object
 */
public class GetFacultiesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Faculty> items;

    public Integer getCount() {
        return count;
    }

    public GetFacultiesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Faculty> getItems() {
        return items;
    }

    public GetFacultiesResponse setItems(List<Faculty> items) {
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
        GetFacultiesResponse getFacultiesResponse = (GetFacultiesResponse) o;
        return Objects.equals(count, getFacultiesResponse.count) &&
                Objects.equals(items, getFacultiesResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetFacultiesResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
