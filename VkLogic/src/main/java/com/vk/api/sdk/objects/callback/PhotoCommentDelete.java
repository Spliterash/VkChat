package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * PhotoCommentDelete object
 */
public class PhotoCommentDelete implements Validable {
    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("photo_id")
    private Integer photoId;

    public Integer getId() {
        return id;
    }

    public PhotoCommentDelete setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public PhotoCommentDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public PhotoCommentDelete setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public PhotoCommentDelete setPhotoId(Integer photoId) {
        this.photoId = photoId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, id, ownerId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoCommentDelete photoCommentDelete = (PhotoCommentDelete) o;
        return Objects.equals(photoId, photoCommentDelete.photoId) &&
                Objects.equals(userId, photoCommentDelete.userId) &&
                Objects.equals(ownerId, photoCommentDelete.ownerId) &&
                Objects.equals(id, photoCommentDelete.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PhotoCommentDelete{");
        sb.append("photoId=").append(photoId);
        sb.append(", userId=").append(userId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
