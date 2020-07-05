package com.vk.api.sdk.objects.fave.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.photos.Photo;
import java.util.List;
import java.util.Objects;

/**
 * GetPhotosResponse object
 */
public class GetPhotosResponse implements Validable {
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

    public GetPhotosResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Photo> getItems() {
        return items;
    }

    public GetPhotosResponse setItems(List<Photo> items) {
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
        GetPhotosResponse getPhotosResponse = (GetPhotosResponse) o;
        return Objects.equals(count, getPhotosResponse.count) &&
                Objects.equals(items, getPhotosResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetPhotosResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
