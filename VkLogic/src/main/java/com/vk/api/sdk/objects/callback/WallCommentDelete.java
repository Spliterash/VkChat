package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * WallCommentDelete object
 */
public class WallCommentDelete implements Validable {
    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("post_id")
    private Integer postId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public WallCommentDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public WallCommentDelete setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public WallCommentDelete setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPostId() {
        return postId;
    }

    public WallCommentDelete setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, id, ownerId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallCommentDelete wallCommentDelete = (WallCommentDelete) o;
        return Objects.equals(postId, wallCommentDelete.postId) &&
                Objects.equals(userId, wallCommentDelete.userId) &&
                Objects.equals(ownerId, wallCommentDelete.ownerId) &&
                Objects.equals(id, wallCommentDelete.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("WallCommentDelete{");
        sb.append("postId=").append(postId);
        sb.append(", userId=").append(userId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
