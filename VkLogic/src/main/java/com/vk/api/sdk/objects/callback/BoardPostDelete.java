package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * BoardPostDelete object
 */
public class BoardPostDelete implements Validable {
    @SerializedName("topic_owner_id")
    private Integer topicOwnerId;

    @SerializedName("topic_id")
    private Integer topicId;

    @SerializedName("id")
    @Required
    private Integer id;

    public Integer getTopicOwnerId() {
        return topicOwnerId;
    }

    public BoardPostDelete setTopicOwnerId(Integer topicOwnerId) {
        this.topicOwnerId = topicOwnerId;
        return this;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public BoardPostDelete setTopicId(Integer topicId) {
        this.topicId = topicId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public BoardPostDelete setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, topicOwnerId, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPostDelete boardPostDelete = (BoardPostDelete) o;
        return Objects.equals(topicOwnerId, boardPostDelete.topicOwnerId) &&
                Objects.equals(topicId, boardPostDelete.topicId) &&
                Objects.equals(id, boardPostDelete.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("BoardPostDelete{");
        sb.append("topicOwnerId=").append(topicOwnerId);
        sb.append(", topicId=").append(topicId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
