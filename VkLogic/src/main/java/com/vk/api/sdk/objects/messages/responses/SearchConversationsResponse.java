package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.Conversation;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.List;
import java.util.Objects;

/**
 * SearchConversationsResponse object
 */
public class SearchConversationsResponse implements Validable {
    /**
     * Total results number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<Conversation> items;

    @SerializedName("profiles")
    private List<UserFull> profiles;

    @SerializedName("groups")
    private List<GroupFull> groups;

    public Integer getCount() {
        return count;
    }

    public SearchConversationsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Conversation> getItems() {
        return items;
    }

    public SearchConversationsResponse setItems(List<Conversation> items) {
        this.items = items;
        return this;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public SearchConversationsResponse setProfiles(List<UserFull> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public SearchConversationsResponse setGroups(List<GroupFull> groups) {
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
        SearchConversationsResponse searchConversationsResponse = (SearchConversationsResponse) o;
        return Objects.equals(count, searchConversationsResponse.count) &&
                Objects.equals(profiles, searchConversationsResponse.profiles) &&
                Objects.equals(groups, searchConversationsResponse.groups) &&
                Objects.equals(items, searchConversationsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SearchConversationsResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
