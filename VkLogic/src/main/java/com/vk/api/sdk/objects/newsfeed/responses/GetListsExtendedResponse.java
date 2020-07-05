package com.vk.api.sdk.objects.newsfeed.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.newsfeed.ListFull;
import java.util.List;
import java.util.Objects;

/**
 * GetListsExtendedResponse object
 */
public class GetListsExtendedResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<ListFull> items;

    public Integer getCount() {
        return count;
    }

    public GetListsExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<ListFull> getItems() {
        return items;
    }

    public GetListsExtendedResponse setItems(List<ListFull> items) {
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
        GetListsExtendedResponse getListsExtendedResponse = (GetListsExtendedResponse) o;
        return Objects.equals(count, getListsExtendedResponse.count) &&
                Objects.equals(items, getListsExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetListsExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
