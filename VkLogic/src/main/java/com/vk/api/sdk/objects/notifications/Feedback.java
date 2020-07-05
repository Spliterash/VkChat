package com.vk.api.sdk.objects.notifications;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.base.Geo;
import com.vk.api.sdk.objects.base.LikesInfo;
import com.vk.api.sdk.objects.wall.WallpostAttachment;
import java.util.List;
import java.util.Objects;

/**
 * Feedback object
 */
public class Feedback implements Validable {
    @SerializedName("attachments")
    private List<WallpostAttachment> attachments;

    /**
     * Reply author's ID
     */
    @SerializedName("from_id")
    private Integer fromId;

    @SerializedName("geo")
    private Geo geo;

    /**
     * Item ID
     */
    @SerializedName("id")
    private Integer id;

    @SerializedName("likes")
    private LikesInfo likes;

    /**
     * Reply text
     */
    @SerializedName("text")
    private String text;

    /**
     * Wall owner's ID
     */
    @SerializedName("to_id")
    private Integer toId;

    public List<WallpostAttachment> getAttachments() {
        return attachments;
    }

    public Feedback setAttachments(List<WallpostAttachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Integer getFromId() {
        return fromId;
    }

    public Feedback setFromId(Integer fromId) {
        this.fromId = fromId;
        return this;
    }

    public Geo getGeo() {
        return geo;
    }

    public Feedback setGeo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Feedback setId(Integer id) {
        this.id = id;
        return this;
    }

    public LikesInfo getLikes() {
        return likes;
    }

    public Feedback setLikes(LikesInfo likes) {
        this.likes = likes;
        return this;
    }

    public String getText() {
        return text;
    }

    public Feedback setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getToId() {
        return toId;
    }

    public Feedback setToId(Integer toId) {
        this.toId = toId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(geo, toId, attachments, id, text, fromId, likes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(geo, feedback.geo) &&
                Objects.equals(attachments, feedback.attachments) &&
                Objects.equals(fromId, feedback.fromId) &&
                Objects.equals(toId, feedback.toId) &&
                Objects.equals(id, feedback.id) &&
                Objects.equals(text, feedback.text) &&
                Objects.equals(likes, feedback.likes);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Feedback{");
        sb.append("geo=").append(geo);
        sb.append(", attachments=").append(attachments);
        sb.append(", fromId=").append(fromId);
        sb.append(", toId=").append(toId);
        sb.append(", id=").append(id);
        sb.append(", text='").append(text).append("'");
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
