package com.vk.api.sdk.objects.stories.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.List;
import java.util.Objects;

/**
 * GetBannedExtendedResponse object
 */
public class GetBannedExtendedResponse implements Validable {
    /**
     * Stories count
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Integer> items;

    @SerializedName("profiles")
    @Required
    private List<UserFull> profiles;

    @SerializedName("groups")
    @Required
    private List<GroupFull> groups;

    public Integer getCount() {
        return count;
    }

    public GetBannedExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Integer> getItems() {
        return items;
    }

    public GetBannedExtendedResponse setItems(List<Integer> items) {
        this.items = items;
        return this;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public GetBannedExtendedResponse setProfiles(List<UserFull> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public GetBannedExtendedResponse setGroups(List<GroupFull> groups) {
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
        GetBannedExtendedResponse getBannedExtendedResponse = (GetBannedExtendedResponse) o;
        return Objects.equals(count, getBannedExtendedResponse.count) &&
                Objects.equals(profiles, getBannedExtendedResponse.profiles) &&
                Objects.equals(groups, getBannedExtendedResponse.groups) &&
                Objects.equals(items, getBannedExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetBannedExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
