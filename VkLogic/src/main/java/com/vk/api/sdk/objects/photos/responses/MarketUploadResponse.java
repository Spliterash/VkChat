package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * MarketUploadResponse object
 */
public class MarketUploadResponse implements Validable {
    /**
     * Crop data
     */
    @SerializedName("crop_data")
    private String cropData;

    /**
     * Crop hash
     */
    @SerializedName("crop_hash")
    private String cropHash;

    /**
     * Community ID
     */
    @SerializedName("group_id")
    private Integer groupId;

    /**
     * Uploading hash
     */
    @SerializedName("hash")
    private String hash;

    /**
     * Uploaded photo data
     */
    @SerializedName("photo")
    private String photo;

    /**
     * Upload server number
     */
    @SerializedName("server")
    private Integer server;

    public String getCropData() {
        return cropData;
    }

    public MarketUploadResponse setCropData(String cropData) {
        this.cropData = cropData;
        return this;
    }

    public String getCropHash() {
        return cropHash;
    }

    public MarketUploadResponse setCropHash(String cropHash) {
        this.cropHash = cropHash;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MarketUploadResponse setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public MarketUploadResponse setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public MarketUploadResponse setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Integer getServer() {
        return server;
    }

    public MarketUploadResponse setServer(Integer server) {
        this.server = server;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, cropData, groupId, photo, hash, cropHash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketUploadResponse marketUploadResponse = (MarketUploadResponse) o;
        return Objects.equals(cropData, marketUploadResponse.cropData) &&
                Objects.equals(server, marketUploadResponse.server) &&
                Objects.equals(groupId, marketUploadResponse.groupId) &&
                Objects.equals(cropHash, marketUploadResponse.cropHash) &&
                Objects.equals(photo, marketUploadResponse.photo) &&
                Objects.equals(hash, marketUploadResponse.hash);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MarketUploadResponse{");
        sb.append("cropData='").append(cropData).append("'");
        sb.append(", server=").append(server);
        sb.append(", groupId=").append(groupId);
        sb.append(", cropHash='").append(cropHash).append("'");
        sb.append(", photo='").append(photo).append("'");
        sb.append(", hash='").append(hash).append("'");
        sb.append('}');
        return sb.toString();
    }
}
