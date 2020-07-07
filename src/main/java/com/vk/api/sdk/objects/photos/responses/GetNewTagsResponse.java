package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.photos.PhotoXtrTagInfo;
import java.util.List;
import java.util.Objects;

/**
 * GetNewTagsResponse object
 */
public class GetNewTagsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<PhotoXtrTagInfo> items;

    public Integer getCount() {
        return count;
    }

    public GetNewTagsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<PhotoXtrTagInfo> getItems() {
        return items;
    }

    public GetNewTagsResponse setItems(List<PhotoXtrTagInfo> items) {
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
        GetNewTagsResponse getNewTagsResponse = (GetNewTagsResponse) o;
        return Objects.equals(count, getNewTagsResponse.count) &&
                Objects.equals(items, getNewTagsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetNewTagsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
