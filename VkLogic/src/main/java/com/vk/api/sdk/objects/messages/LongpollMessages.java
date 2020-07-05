package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * LongpollMessages object
 */
public class LongpollMessages implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Message> items;

    public Integer getCount() {
        return count;
    }

    public LongpollMessages setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Message> getItems() {
        return items;
    }

    public LongpollMessages setItems(List<Message> items) {
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
        LongpollMessages longpollMessages = (LongpollMessages) o;
        return Objects.equals(count, longpollMessages.count) &&
                Objects.equals(items, longpollMessages.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LongpollMessages{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
