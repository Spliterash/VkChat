package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * WallUploadResponse object
 */
public class WallUploadResponse implements Validable {
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

    public String getHash() {
        return hash;
    }

    public WallUploadResponse setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public WallUploadResponse setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Integer getServer() {
        return server;
    }

    public WallUploadResponse setServer(Integer server) {
        this.server = server;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, photo, hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WallUploadResponse wallUploadResponse = (WallUploadResponse) o;
        return Objects.equals(server, wallUploadResponse.server) &&
                Objects.equals(photo, wallUploadResponse.photo) &&
                Objects.equals(hash, wallUploadResponse.hash);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("WallUploadResponse{");
        sb.append("server=").append(server);
        sb.append(", photo='").append(photo).append("'");
        sb.append(", hash='").append(hash).append("'");
        sb.append('}');
        return sb.toString();
    }
}
