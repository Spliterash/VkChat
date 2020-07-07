package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * ItemPhotoPhotos object
 */
public class ItemPhotoPhotos implements Validable {
    /**
     * Photos number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<NewsfeedPhoto> items;

    public Integer getCount() {
        return count;
    }

    public ItemPhotoPhotos setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<NewsfeedPhoto> getItems() {
        return items;
    }

    public ItemPhotoPhotos setItems(List<NewsfeedPhoto> items) {
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
        ItemPhotoPhotos itemPhotoPhotos = (ItemPhotoPhotos) o;
        return Objects.equals(count, itemPhotoPhotos.count) &&
                Objects.equals(items, itemPhotoPhotos.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ItemPhotoPhotos{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
