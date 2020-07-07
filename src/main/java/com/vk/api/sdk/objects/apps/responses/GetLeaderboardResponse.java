package com.vk.api.sdk.objects.apps.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.apps.Leaderboard;
import java.util.List;
import java.util.Objects;

/**
 * GetLeaderboardResponse object
 */
public class GetLeaderboardResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Leaderboard> items;

    public Integer getCount() {
        return count;
    }

    public GetLeaderboardResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Leaderboard> getItems() {
        return items;
    }

    public GetLeaderboardResponse setItems(List<Leaderboard> items) {
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
        GetLeaderboardResponse getLeaderboardResponse = (GetLeaderboardResponse) o;
        return Objects.equals(count, getLeaderboardResponse.count) &&
                Objects.equals(items, getLeaderboardResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetLeaderboardResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
