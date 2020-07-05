package com.vk.api.sdk.objects.widgets;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.Objects;

/**
 * CommentRepliesItem object
 */
public class CommentRepliesItem implements Validable {
    /**
     * Comment ID
     */
    @SerializedName("cid")
    private Integer cid;

    /**
     * Date when the comment has been added in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    @SerializedName("likes")
    private WidgetLikes likes;

    /**
     * Comment text
     */
    @SerializedName("text")
    private String text;

    /**
     * User ID
     */
    @SerializedName("uid")
    private Integer uid;

    @SerializedName("user")
    private UserFull user;

    public Integer getCid() {
        return cid;
    }

    public CommentRepliesItem setCid(Integer cid) {
        this.cid = cid;
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public CommentRepliesItem setDate(Integer date) {
        this.date = date;
        return this;
    }

    public WidgetLikes getLikes() {
        return likes;
    }

    public CommentRepliesItem setLikes(WidgetLikes likes) {
        this.likes = likes;
        return this;
    }

    public String getText() {
        return text;
    }

    public CommentRepliesItem setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getUid() {
        return uid;
    }

    public CommentRepliesItem setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public UserFull getUser() {
        return user;
    }

    public CommentRepliesItem setUser(UserFull user) {
        this.user = user;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, uid, text, user, cid, likes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentRepliesItem commentRepliesItem = (CommentRepliesItem) o;
        return Objects.equals(date, commentRepliesItem.date) &&
                Objects.equals(uid, commentRepliesItem.uid) &&
                Objects.equals(text, commentRepliesItem.text) &&
                Objects.equals(user, commentRepliesItem.user) &&
                Objects.equals(cid, commentRepliesItem.cid) &&
                Objects.equals(likes, commentRepliesItem.likes);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CommentRepliesItem{");
        sb.append("date=").append(date);
        sb.append(", uid=").append(uid);
        sb.append(", text='").append(text).append("'");
        sb.append(", user=").append(user);
        sb.append(", cid=").append(cid);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
