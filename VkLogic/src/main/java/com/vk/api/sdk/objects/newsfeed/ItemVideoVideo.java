package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.video.Video;
import java.util.List;
import java.util.Objects;

/**
 * ItemVideoVideo object
 */
public class ItemVideoVideo implements Validable {
    /**
     * Tags number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Video> items;

    public Integer getCount() {
        return count;
    }

    public ItemVideoVideo setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Video> getItems() {
        return items;
    }

    public ItemVideoVideo setItems(List<Video> items) {
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
        ItemVideoVideo itemVideoVideo = (ItemVideoVideo) o;
        return Objects.equals(count, itemVideoVideo.count) &&
                Objects.equals(items, itemVideoVideo.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ItemVideoVideo{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
