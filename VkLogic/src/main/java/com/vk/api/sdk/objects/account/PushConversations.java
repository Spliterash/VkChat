package com.vk.api.sdk.objects.account;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * PushConversations object
 */
public class PushConversations implements Validable {
    /**
     * Items count
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<PushConversationsItem> items;

    public Integer getCount() {
        return count;
    }

    public PushConversations setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<PushConversationsItem> getItems() {
        return items;
    }

    public PushConversations setItems(List<PushConversationsItem> items) {
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
        PushConversations pushConversations = (PushConversations) o;
        return Objects.equals(count, pushConversations.count) &&
                Objects.equals(items, pushConversations.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PushConversations{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
