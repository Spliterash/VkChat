package com.vk.api.sdk.objects.video.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AddAlbumResponse object
 */
public class AddAlbumResponse implements Validable {
    /**
     * Created album ID
     */
    @SerializedName("album_id")
    private Integer albumId;

    public Integer getAlbumId() {
        return albumId;
    }

    public AddAlbumResponse setAlbumId(Integer albumId) {
        this.albumId = albumId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddAlbumResponse addAlbumResponse = (AddAlbumResponse) o;
        return Objects.equals(albumId, addAlbumResponse.albumId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddAlbumResponse{");
        sb.append("albumId=").append(albumId);
        sb.append('}');
        return sb.toString();
    }
}
