package com.vk.api.sdk.objects.users.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupsArray;
import com.vk.api.sdk.objects.users.UsersArray;
import java.util.Objects;

/**
 * GetSubscriptionsResponse object
 */
public class GetSubscriptionsResponse implements Validable {
    @SerializedName("users")
    @Required
    private UsersArray users;

    @SerializedName("groups")
    @Required
    private GroupsArray groups;

    public UsersArray getUsers() {
        return users;
    }

    public GetSubscriptionsResponse setUsers(UsersArray users) {
        this.users = users;
        return this;
    }

    public GroupsArray getGroups() {
        return groups;
    }

    public GetSubscriptionsResponse setGroups(GroupsArray groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetSubscriptionsResponse getSubscriptionsResponse = (GetSubscriptionsResponse) o;
        return Objects.equals(groups, getSubscriptionsResponse.groups) &&
                Objects.equals(users, getSubscriptionsResponse.users);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetSubscriptionsResponse{");
        sb.append("groups=").append(groups);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
