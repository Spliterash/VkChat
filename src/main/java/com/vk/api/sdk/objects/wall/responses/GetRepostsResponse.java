package com.vk.api.sdk.objects.wall.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.Group;
import com.vk.api.sdk.objects.users.User;
import com.vk.api.sdk.objects.wall.WallpostFull;
import java.util.List;
import java.util.Objects;

/**
 * GetRepostsResponse object
 */
public class GetRepostsResponse implements Validable {
    @SerializedName("items")
    @Required
    private List<WallpostFull> items;

    @SerializedName("profiles")
    @Required
    private List<User> profiles;

    @SerializedName("groups")
    @Required
    private List<Group> groups;

    public List<WallpostFull> getItems() {
        return items;
    }

    public GetRepostsResponse setItems(List<WallpostFull> items) {
        this.items = items;
        return this;
    }

    public List<User> getProfiles() {
        return profiles;
    }

    public GetRepostsResponse setProfiles(List<User> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public GetRepostsResponse setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profiles, groups, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetRepostsResponse getRepostsResponse = (GetRepostsResponse) o;
        return Objects.equals(profiles, getRepostsResponse.profiles) &&
                Objects.equals(groups, getRepostsResponse.groups) &&
                Objects.equals(items, getRepostsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetRepostsResponse{");
        sb.append("profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
