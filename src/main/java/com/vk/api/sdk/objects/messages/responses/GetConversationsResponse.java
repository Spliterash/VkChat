package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.ConversationWithMessage;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.List;
import java.util.Objects;

/**
 * GetConversationsResponse object
 */
public class GetConversationsResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    /**
     * Unread dialogs number
     */
    @SerializedName("unread_count")
    private Integer unreadCount;

    @SerializedName("items")
    @Required
    private List<ConversationWithMessage> items;

    @SerializedName("profiles")
    private List<UserFull> profiles;

    @SerializedName("groups")
    private List<GroupFull> groups;

    public Integer getCount() {
        return count;
    }

    public GetConversationsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public GetConversationsResponse setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
        return this;
    }

    public List<ConversationWithMessage> getItems() {
        return items;
    }

    public GetConversationsResponse setItems(List<ConversationWithMessage> items) {
        this.items = items;
        return this;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public GetConversationsResponse setProfiles(List<UserFull> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public GetConversationsResponse setGroups(List<GroupFull> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, profiles, unreadCount, groups, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetConversationsResponse getConversationsResponse = (GetConversationsResponse) o;
        return Objects.equals(unreadCount, getConversationsResponse.unreadCount) &&
                Objects.equals(count, getConversationsResponse.count) &&
                Objects.equals(profiles, getConversationsResponse.profiles) &&
                Objects.equals(groups, getConversationsResponse.groups) &&
                Objects.equals(items, getConversationsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetConversationsResponse{");
        sb.append("unreadCount=").append(unreadCount);
        sb.append(", count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
