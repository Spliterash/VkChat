package com.vk.api.sdk.objects.friends.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.friends.Requests;
import java.util.List;
import java.util.Objects;

/**
 * GetRequestsNeedMutualResponse object
 */
public class GetRequestsNeedMutualResponse implements Validable {
    /**
     * Total requests number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Requests> items;

    public Integer getCount() {
        return count;
    }

    public GetRequestsNeedMutualResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Requests> getItems() {
        return items;
    }

    public GetRequestsNeedMutualResponse setItems(List<Requests> items) {
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
        GetRequestsNeedMutualResponse getRequestsNeedMutualResponse = (GetRequestsNeedMutualResponse) o;
        return Objects.equals(count, getRequestsNeedMutualResponse.count) &&
                Objects.equals(items, getRequestsNeedMutualResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetRequestsNeedMutualResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
