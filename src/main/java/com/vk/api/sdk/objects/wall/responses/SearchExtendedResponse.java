package com.vk.api.sdk.objects.wall.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.users.UserFull;
import com.vk.api.sdk.objects.wall.WallpostFull;
import java.util.List;
import java.util.Objects;

/**
 * SearchExtendedResponse object
 */
public class SearchExtendedResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<WallpostFull> items;

    @SerializedName("profiles")
    @Required
    private List<UserFull> profiles;

    @SerializedName("groups")
    @Required
    private List<GroupFull> groups;

    public Integer getCount() {
        return count;
    }

    public SearchExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<WallpostFull> getItems() {
        return items;
    }

    public SearchExtendedResponse setItems(List<WallpostFull> items) {
        this.items = items;
        return this;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public SearchExtendedResponse setProfiles(List<UserFull> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public SearchExtendedResponse setGroups(List<GroupFull> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, profiles, groups, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchExtendedResponse searchExtendedResponse = (SearchExtendedResponse) o;
        return Objects.equals(count, searchExtendedResponse.count) &&
                Objects.equals(profiles, searchExtendedResponse.profiles) &&
                Objects.equals(groups, searchExtendedResponse.groups) &&
                Objects.equals(items, searchExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SearchExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
