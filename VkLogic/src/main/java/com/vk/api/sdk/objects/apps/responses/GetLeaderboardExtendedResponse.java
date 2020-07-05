package com.vk.api.sdk.objects.apps.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.apps.Leaderboard;
import com.vk.api.sdk.objects.users.UserMin;
import java.util.List;
import java.util.Objects;

/**
 * GetLeaderboardExtendedResponse object
 */
public class GetLeaderboardExtendedResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Leaderboard> items;

    @SerializedName("profiles")
    private List<UserMin> profiles;

    public Integer getCount() {
        return count;
    }

    public GetLeaderboardExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Leaderboard> getItems() {
        return items;
    }

    public GetLeaderboardExtendedResponse setItems(List<Leaderboard> items) {
        this.items = items;
        return this;
    }

    public List<UserMin> getProfiles() {
        return profiles;
    }

    public GetLeaderboardExtendedResponse setProfiles(List<UserMin> profiles) {
        this.profiles = profiles;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, profiles, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLeaderboardExtendedResponse getLeaderboardExtendedResponse = (GetLeaderboardExtendedResponse) o;
        return Objects.equals(count, getLeaderboardExtendedResponse.count) &&
                Objects.equals(profiles, getLeaderboardExtendedResponse.profiles) &&
                Objects.equals(items, getLeaderboardExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetLeaderboardExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
