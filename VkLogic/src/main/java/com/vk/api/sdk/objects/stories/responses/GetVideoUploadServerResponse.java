package com.vk.api.sdk.objects.stories.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * GetVideoUploadServerResponse object
 */
public class GetVideoUploadServerResponse implements Validable {
    /**
     * Upload URL
     */
    @SerializedName("upload_url")
    private String uploadUrl;

    /**
     * Users ID who can to see story.
     */
    @SerializedName("user_ids")
    private List<Integer> userIds;

    public String getUploadUrl() {
        return uploadUrl;
    }

    public GetVideoUploadServerResponse setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public GetVideoUploadServerResponse setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uploadUrl, userIds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetVideoUploadServerResponse getVideoUploadServerResponse = (GetVideoUploadServerResponse) o;
        return Objects.equals(userIds, getVideoUploadServerResponse.userIds) &&
                Objects.equals(uploadUrl, getVideoUploadServerResponse.uploadUrl);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetVideoUploadServerResponse{");
        sb.append("userIds=").append(userIds);
        sb.append(", uploadUrl='").append(uploadUrl).append("'");
        sb.append('}');
        return sb.toString();
    }
}
