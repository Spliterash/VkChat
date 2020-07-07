package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.wall.WallComment;
import java.util.List;
import java.util.Objects;

/**
 * GetCommentsResponse object
 */
public class GetCommentsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Real offset of the comments
     */
    @SerializedName("real_offset")
    private Integer realOffset;

    @SerializedName("items")
    private List<WallComment> items;

    public Integer getCount() {
        return count;
    }

    public GetCommentsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getRealOffset() {
        return realOffset;
    }

    public GetCommentsResponse setRealOffset(Integer realOffset) {
        this.realOffset = realOffset;
        return this;
    }

    public List<WallComment> getItems() {
        return items;
    }

    public GetCommentsResponse setItems(List<WallComment> items) {
        this.items = items;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realOffset, count, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCommentsResponse getCommentsResponse = (GetCommentsResponse) o;
        return Objects.equals(realOffset, getCommentsResponse.realOffset) &&
                Objects.equals(count, getCommentsResponse.count) &&
                Objects.equals(items, getCommentsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCommentsResponse{");
        sb.append("realOffset=").append(realOffset);
        sb.append(", count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
