package com.vk.api.sdk.objects.wall.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * PostAdsStealthResponse object
 */
public class PostAdsStealthResponse implements Validable {
    /**
     * Created post ID
     */
    @SerializedName("post_id")
    private Integer postId;

    public Integer getPostId() {
        return postId;
    }

    public PostAdsStealthResponse setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostAdsStealthResponse postAdsStealthResponse = (PostAdsStealthResponse) o;
        return Objects.equals(postId, postAdsStealthResponse.postId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PostAdsStealthResponse{");
        sb.append("postId=").append(postId);
        sb.append('}');
        return sb.toString();
    }
}
