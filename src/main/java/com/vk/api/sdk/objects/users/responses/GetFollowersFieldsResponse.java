package com.vk.api.sdk.objects.users.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.List;
import java.util.Objects;

/**
 * GetFollowersFieldsResponse object
 */
public class GetFollowersFieldsResponse implements Validable {
    /**
     * Total number of available results
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<UserFull> items;

    public Integer getCount() {
        return count;
    }

    public GetFollowersFieldsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<UserFull> getItems() {
        return items;
    }

    public GetFollowersFieldsResponse setItems(List<UserFull> items) {
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
        GetFollowersFieldsResponse getFollowersFieldsResponse = (GetFollowersFieldsResponse) o;
        return Objects.equals(count, getFollowersFieldsResponse.count) &&
                Objects.equals(items, getFollowersFieldsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetFollowersFieldsResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
