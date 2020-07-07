package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Activity stats
 */
public class Activity implements Validable {
    /**
     * Comments number
     */
    @SerializedName("comments")
    private Integer comments;

    /**
     * Reposts number
     */
    @SerializedName("copies")
    private Integer copies;

    /**
     * Hidden from news count
     */
    @SerializedName("hidden")
    private Integer hidden;

    /**
     * Likes number
     */
    @SerializedName("likes")
    private Integer likes;

    /**
     * New subscribers count
     */
    @SerializedName("subscribed")
    private Integer subscribed;

    /**
     * Unsubscribed count
     */
    @SerializedName("unsubscribed")
    private Integer unsubscribed;

    public Integer getComments() {
        return comments;
    }

    public Activity setComments(Integer comments) {
        this.comments = comments;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Activity setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public Integer getHidden() {
        return hidden;
    }

    public Activity setHidden(Integer hidden) {
        this.hidden = hidden;
        return this;
    }

    public Integer getLikes() {
        return likes;
    }

    public Activity setLikes(Integer likes) {
        this.likes = likes;
        return this;
    }

    public Integer getSubscribed() {
        return subscribed;
    }

    public Activity setSubscribed(Integer subscribed) {
        this.subscribed = subscribed;
        return this;
    }

    public Integer getUnsubscribed() {
        return unsubscribed;
    }

    public Activity setUnsubscribed(Integer unsubscribed) {
        this.unsubscribed = unsubscribed;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribed, unsubscribed, comments, copies, hidden, likes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(subscribed, activity.subscribed) &&
                Objects.equals(unsubscribed, activity.unsubscribed) &&
                Objects.equals(comments, activity.comments) &&
                Objects.equals(copies, activity.copies) &&
                Objects.equals(hidden, activity.hidden) &&
                Objects.equals(likes, activity.likes);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Activity{");
        sb.append("subscribed=").append(subscribed);
        sb.append(", unsubscribed=").append(unsubscribed);
        sb.append(", comments=").append(comments);
        sb.append(", copies=").append(copies);
        sb.append(", hidden=").append(hidden);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
