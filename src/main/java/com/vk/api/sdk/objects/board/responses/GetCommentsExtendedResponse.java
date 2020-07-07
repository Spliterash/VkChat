package com.vk.api.sdk.objects.board.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.board.TopicComment;
import com.vk.api.sdk.objects.board.TopicPoll;
import com.vk.api.sdk.objects.groups.Group;
import com.vk.api.sdk.objects.users.User;
import java.util.List;
import java.util.Objects;

/**
 * GetCommentsExtendedResponse object
 */
public class GetCommentsExtendedResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<TopicComment> items;

    @SerializedName("poll")
    private TopicPoll poll;

    @SerializedName("profiles")
    @Required
    private List<User> profiles;

    @SerializedName("groups")
    @Required
    private List<Group> groups;

    public Integer getCount() {
        return count;
    }

    public GetCommentsExtendedResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<TopicComment> getItems() {
        return items;
    }

    public GetCommentsExtendedResponse setItems(List<TopicComment> items) {
        this.items = items;
        return this;
    }

    public TopicPoll getPoll() {
        return poll;
    }

    public GetCommentsExtendedResponse setPoll(TopicPoll poll) {
        this.poll = poll;
        return this;
    }

    public List<User> getProfiles() {
        return profiles;
    }

    public GetCommentsExtendedResponse setProfiles(List<User> profiles) {
        this.profiles = profiles;
        return this;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public GetCommentsExtendedResponse setGroups(List<Group> groups) {
        this.groups = groups;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, profiles, groups, poll, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCommentsExtendedResponse getCommentsExtendedResponse = (GetCommentsExtendedResponse) o;
        return Objects.equals(count, getCommentsExtendedResponse.count) &&
                Objects.equals(profiles, getCommentsExtendedResponse.profiles) &&
                Objects.equals(groups, getCommentsExtendedResponse.groups) &&
                Objects.equals(poll, getCommentsExtendedResponse.poll) &&
                Objects.equals(items, getCommentsExtendedResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCommentsExtendedResponse{");
        sb.append("count=").append(count);
        sb.append(", profiles=").append(profiles);
        sb.append(", groups=").append(groups);
        sb.append(", poll=").append(poll);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
