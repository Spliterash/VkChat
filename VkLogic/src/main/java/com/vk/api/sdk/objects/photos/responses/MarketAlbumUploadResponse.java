package com.vk.api.sdk.objects.photos.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * MarketAlbumUploadResponse object
 */
public class MarketAlbumUploadResponse implements Validable {
    /**
     * Community ID
     */
    @SerializedName("gid")
    private Integer gid;

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

    public Integer getGid() {
        return gid;
    }

    public MarketAlbumUploadResponse setGid(Integer gid) {
        this.gid = gid;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public MarketAlbumUploadResponse setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public MarketAlbumUploadResponse setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Integer getServer() {
        return server;
    }

    public MarketAlbumUploadResponse setServer(Integer server) {
        this.server = server;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, gid, photo, hash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketAlbumUploadResponse marketAlbumUploadResponse = (MarketAlbumUploadResponse) o;
        return Objects.equals(server, marketAlbumUploadResponse.server) &&
                Objects.equals(gid, marketAlbumUploadResponse.gid) &&
                Objects.equals(photo, marketAlbumUploadResponse.photo) &&
                Objects.equals(hash, marketAlbumUploadResponse.hash);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MarketAlbumUploadResponse{");
        sb.append("server=").append(server);
        sb.append(", gid=").append(gid);
        sb.append(", photo='").append(photo).append("'");
        sb.append(", hash='").append(hash).append("'");
        sb.append('}');
        return sb.toString();
    }
}
