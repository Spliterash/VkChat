package com.vk.api.sdk.objects.board.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.board.TopicComment;
import com.vk.api.sdk.objects.board.TopicPoll;
import java.util.List;
import java.util.Objects;

/**
 * GetCommentsResponse object
 */
public class GetCommentsResponse implements Validable {
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

    public Integer getCount() {
        return count;
    }

    public GetCommentsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<TopicComment> getItems() {
        return items;
    }

    public GetCommentsResponse setItems(List<TopicComment> items) {
        this.items = items;
        return this;
    }

    public TopicPoll getPoll() {
        return poll;
    }

    public GetCommentsResponse setPoll(TopicPoll poll) {
        this.poll = poll;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, poll, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCommentsResponse getCommentsResponse = (GetCommentsResponse) o;
        return Objects.equals(count, getCommentsResponse.count) &&
                Objects.equals(poll, getCommentsResponse.poll) &&
                Objects.equals(items, getCommentsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCommentsResponse{");
        sb.append("count=").append(count);
        sb.append(", poll=").append(poll);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
