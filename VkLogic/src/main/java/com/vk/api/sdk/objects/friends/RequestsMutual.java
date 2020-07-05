package com.vk.api.sdk.objects.friends;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * RequestsMutual object
 */
public class RequestsMutual implements Validable {
    /**
     * Total mutual friends number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("users")
    private List<Integer> users;

    public Integer getCount() {
        return count;
    }

    public RequestsMutual setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public RequestsMutual setUsers(List<Integer> users) {
        this.users = users;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestsMutual requestsMutual = (RequestsMutual) o;
        return Objects.equals(count, requestsMutual.count) &&
                Objects.equals(users, requestsMutual.users);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("RequestsMutual{");
        sb.append("count=").append(count);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
