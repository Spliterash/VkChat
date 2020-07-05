package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFull;
import com.vk.api.sdk.objects.messages.ChatRestrictions;
import com.vk.api.sdk.objects.messages.ConversationMember;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.List;
import java.util.Objects;

/**
 * GetConversationMembersResponse object
 */
public class GetConversationMembersResponse implements Validable {
    /**
     * Chat members count
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<ConversationMember> items;

    @SerializedName("chat_restrictions")
    private ChatRestrictions chatRestrictions;

    @SerializedName("profiles")
    private List<UserFull> profiles;

    @SerializedName("groups")
    private List<GroupFull> groups;

    public Integer getCount() {
        return count;
    }

    public GetConversationMembersResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<ConversationMember> getItems() {
        return items;
    }

    public GetConversationMembersResponse setItems(List<ConversationMember> items) {
        this.items = items;
        return this;
    }

    public ChatRestrictions getChatRestrictions() {
        return chatRestrictions;
    }

    public GetConversationMembersResponse setChatRestrictions(ChatRestrictions chatRestrictions) {
        this.chatRestrictions = chatRestrictions;
        return this;
    }

    public List<UserFull> getProfiles() {
        return profiles;
    }

    public GetConversationMembersResponse setProfiles(List<UserFull> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<GroupFull> getGroups() {
        return groups;
    }

    public GetConversationMembersResponse setGroups(List<GroupFull> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatRestrictions, count, profiles, groups, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetConversationMembersResponse getConversationMembersResponse = (GetConversationMembersResponse) o;
        return Objects.equals(count, getConversationMembersResponse.count) &&
                Objects.equals(profiles, getConversationMembersResponse.profiles) &&
                Objects.equals(groups, getConversationMembersResponse.groups) &&
                Objects.equals(items, getConversationMembersResponse.items) &&
                Objects.equals(chatRestrictions, getConversationMembersResponse.chatRestrictions);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetConversationMembersResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", items=").append(items);
        sb.append(", chatRestrictions=").append(chatRestrictions);
        sb.append('}');
        return sb.toString();
    }
}
