package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.List;
import java.util.Objects;

/**
 * GroupsArray object
 */
public class GroupsArray implements Validable {
    /**
     * Communities number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Integer> items;

    public Integer getCount() {
        return count;
    }

    public GroupsArray setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Integer> getItems() {
        return items;
    }

    public GroupsArray setItems(List<Integer> items) {
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
        GroupsArray groupsArray = (GroupsArray) o;
        return Objects.equals(count, groupsArray.count) &&
                Objects.equals(items, groupsArray.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GroupsArray{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
