package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.photos.PhotoFull;
import java.util.List;
import java.util.Objects;

/**
 * GetUserPhotosExtendedResponse object
 */
public class GetUserPhotosExtendedResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<PhotoFull> items;

    public Integer getCount() {
        return count;
    }

    public GetUserPhotosExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<PhotoFull> getItems() {
        return items;
    }

    public GetUserPhotosExtendedResponse setItems(List<PhotoFull> items) {
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
        GetUserPhotosExtendedResponse getUserPhotosExtendedResponse = (GetUserPhotosExtendedResponse) o;
        return Objects.equals(count, getUserPhotosExtendedResponse.count) &&
                Objects.equals(items, getUserPhotosExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetUserPhotosExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
