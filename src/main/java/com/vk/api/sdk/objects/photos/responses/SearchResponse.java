package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.photos.Photo;
import java.util.List;
import java.util.Objects;

/**
 * SearchResponse object
 */
public class SearchResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Photo> items;

    public Integer getCount() {
        return count;
    }

    public SearchResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Photo> getItems() {
        return items;
    }

    public SearchResponse setItems(List<Photo> items) {
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
        SearchResponse searchResponse = (SearchResponse) o;
        return Objects.equals(count, searchResponse.count) &&
                Objects.equals(items, searchResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SearchResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
