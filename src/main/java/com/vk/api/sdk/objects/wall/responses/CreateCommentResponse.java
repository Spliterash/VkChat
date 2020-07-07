package com.vk.api.sdk.objects.wall.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * CreateCommentResponse object
 */
public class CreateCommentResponse implements Validable {
    /**
     * Created comment ID
     */
    @SerializedName("comment_id")
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public CreateCommentResponse setCommentId(Integer commentId) {
        this.commentId = commentId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCommentResponse createCommentResponse = (CreateCommentResponse) o;
        return Objects.equals(commentId, createCommentResponse.commentId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CreateCommentResponse{");
        sb.append("commentId=").append(commentId);
        sb.append('}');
        return sb.toString();
    }
}
