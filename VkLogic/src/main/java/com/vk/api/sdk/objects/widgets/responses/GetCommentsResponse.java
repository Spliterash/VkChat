package com.vk.api.sdk.objects.widgets.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.widgets.WidgetComment;
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

    @SerializedName("posts")
    @Required
    private List<WidgetComment> posts;

    public Integer getCount() {
        return count;
    }

    public GetCommentsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<WidgetComment> getPosts() {
        return posts;
    }

    public GetCommentsResponse setPosts(List<WidgetComment> posts) {
        this.posts = posts;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, posts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCommentsResponse getCommentsResponse = (GetCommentsResponse) o;
        return Objects.equals(count, getCommentsResponse.count) &&
                Objects.equals(posts, getCommentsResponse.posts);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCommentsResponse{");
        sb.append("count=").append(count);
        sb.append(", posts=").append(posts);
        sb.append('}');
        return sb.toString();
    }
}
