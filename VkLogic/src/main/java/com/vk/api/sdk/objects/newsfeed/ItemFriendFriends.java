package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.base.UserId;
import java.util.List;
import java.util.Objects;

/**
 * ItemFriendFriends object
 */
public class ItemFriendFriends implements Validable {
    /**
     * Number of friends has been added
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<UserId> items;

    public Integer getCount() {
        return count;
    }

    public ItemFriendFriends setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<UserId> getItems() {
        return items;
    }

    public ItemFriendFriends setItems(List<UserId> items) {
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
        ItemFriendFriends itemFriendFriends = (ItemFriendFriends) o;
        return Objects.equals(count, itemFriendFriends.count) &&
                Objects.equals(items, itemFriendFriends.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ItemFriendFriends{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
