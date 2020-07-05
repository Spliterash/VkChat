package com.vk.api.sdk.objects.docs.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.docs.DocTypes;
import java.util.List;
import java.util.Objects;

/**
 * GetTypesResponse object
 */
public class GetTypesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<DocTypes> items;

    public Integer getCount() {
        return count;
    }

    public GetTypesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<DocTypes> getItems() {
        return items;
    }

    public GetTypesResponse setItems(List<DocTypes> items) {
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
        GetTypesResponse getTypesResponse = (GetTypesResponse) o;
        return Objects.equals(count, getTypesResponse.count) &&
                Objects.equals(items, getTypesResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetTypesResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
