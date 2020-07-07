package com.vk.api.sdk.objects.likes.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * DeleteResponse object
 */
public class DeleteResponse implements Validable {
    /**
     * Total likes number
     */
    @SerializedName("likes")
    @Required
    private Integer likes;

    public Integer getLikes() {
        return likes;
    }

    public DeleteResponse setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteResponse deleteResponse = (DeleteResponse) o;
        return Objects.equals(likes, deleteResponse.likes);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DeleteResponse{");
        sb.append("likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
