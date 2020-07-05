package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.photos.PhotoAlbumFull;
import java.util.List;
import java.util.Objects;

/**
 * GetAlbumsResponse object
 */
public class GetAlbumsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<PhotoAlbumFull> items;

    public Integer getCount() {
        return count;
    }

    public GetAlbumsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<PhotoAlbumFull> getItems() {
        return items;
    }

    public GetAlbumsResponse setItems(List<PhotoAlbumFull> items) {
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
        GetAlbumsResponse getAlbumsResponse = (GetAlbumsResponse) o;
        return Objects.equals(count, getAlbumsResponse.count) &&
                Objects.equals(items, getAlbumsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetAlbumsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
