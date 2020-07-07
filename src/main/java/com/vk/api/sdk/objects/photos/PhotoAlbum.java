package com.vk.api.sdk.objects.photos;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * PhotoAlbum object
 */
public class PhotoAlbum implements Validable {
    /**
     * Date when the album has been created in Unixtime
     */
    @SerializedName("created")
    @Required
    private Integer created;

    /**
     * Photo album description
     */
    @SerializedName("description")
    private String description;

    /**
     * Photo album ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Album owner's ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Photos number
     */
    @SerializedName("size")
    @Required
    private Integer size;

    @SerializedName("thumb")
    private Photo thumb;

    /**
     * Photo album title
     */
    @SerializedName("title")
    @Required
    private String title;

    /**
     * Date when the album has been updated last time in Unixtime
     */
    @SerializedName("updated")
    @Required
    private Integer updated;

    public Integer getCreated() {
        return created;
    }

    public PhotoAlbum setCreated(Integer created) {
        this.created = created;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PhotoAlbum setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public PhotoAlbum setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public PhotoAlbum setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public PhotoAlbum setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Photo getThumb() {
        return thumb;
    }

    public PhotoAlbum setThumb(Photo thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PhotoAlbum setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getUpdated() {
        return updated;
    }

    public PhotoAlbum setUpdated(Integer updated) {
        this.updated = updated;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, thumb, created, description, id, ownerId, title, updated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoAlbum photoAlbum = (PhotoAlbum) o;
        return Objects.equals(size, photoAlbum.size) &&
                Objects.equals(thumb, photoAlbum.thumb) &&
                Objects.equals(created, photoAlbum.created) &&
                Objects.equals(ownerId, photoAlbum.ownerId) &&
                Objects.equals(description, photoAlbum.description) &&
                Objects.equals(id, photoAlbum.id) &&
                Objects.equals(title, photoAlbum.title) &&
                Objects.equals(updated, photoAlbum.updated);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PhotoAlbum{");
        sb.append("size=").append(size);
        sb.append(", thumb=").append(thumb);
        sb.append(", created=").append(created);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", description='").append(description).append("'");
        sb.append(", id=").append(id);
        sb.append(", title='").append(title).append("'");
        sb.append(", updated=").append(updated);
        sb.append('}');
        return sb.toString();
    }
}
