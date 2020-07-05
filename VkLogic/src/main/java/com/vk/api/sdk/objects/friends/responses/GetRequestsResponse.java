package com.vk.api.sdk.objects.friends.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * GetRequestsResponse object
 */
public class GetRequestsResponse implements Validable {
    /**
     * Total requests number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Integer> items;

    /**
     * Total unread requests number
     */
    @SerializedName("count_unread")
    private Integer countUnread;

    public Integer getCount() {
        return count;
    }

    public GetRequestsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Integer> getItems() {
        return items;
    }

    public GetRequestsResponse setItems(List<Integer> items) {
        this.items = items;
        return this;
    }

    public Integer getCountUnread() {
        return countUnread;
    }

    public GetRequestsResponse setCountUnread(Integer countUnread) {
        this.countUnread = countUnread;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, countUnread, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetRequestsResponse getRequestsResponse = (GetRequestsResponse) o;
        return Objects.equals(count, getRequestsResponse.count) &&
                Objects.equals(countUnread, getRequestsResponse.countUnread) &&
                Objects.equals(items, getRequestsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetRequestsResponse{");
        sb.append("count=").append(count);
        sb.append(", countUnread=").append(countUnread);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
