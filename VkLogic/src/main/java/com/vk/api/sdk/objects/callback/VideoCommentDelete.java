package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * VideoCommentDelete object
 */
public class VideoCommentDelete implements Validable {
    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("video_id")
    private Integer videoId;

    public Integer getId() {
        return id;
    }

    public VideoCommentDelete setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public VideoCommentDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public VideoCommentDelete setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public VideoCommentDelete setVideoId(Integer videoId) {
        this.videoId = videoId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoId, id, ownerId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCommentDelete videoCommentDelete = (VideoCommentDelete) o;
        return Objects.equals(userId, videoCommentDelete.userId) &&
                Objects.equals(ownerId, videoCommentDelete.ownerId) &&
                Objects.equals(id, videoCommentDelete.id) &&
                Objects.equals(videoId, videoCommentDelete.videoId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("VideoCommentDelete{");
        sb.append("userId=").append(userId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", id=").append(id);
        sb.append(", videoId=").append(videoId);
        sb.append('}');
        return sb.toString();
    }
}
