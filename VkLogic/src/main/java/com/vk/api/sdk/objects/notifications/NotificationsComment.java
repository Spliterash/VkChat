package com.vk.api.sdk.objects.notifications;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.board.Topic;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.video.Video;
import com.vk.api.sdk.objects.wall.Wallpost;
import java.util.Objects;

/**
 * NotificationsComment object
 */
public class NotificationsComment implements Validable {
    /**
     * Date when the comment has been added in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Comment ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Author ID
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("photo")
    private Photo photo;

    @SerializedName("post")
    private Wallpost post;

    /**
     * Comment text
     */
    @SerializedName("text")
    private String text;

    @SerializedName("topic")
    private Topic topic;

    @SerializedName("video")
    private Video video;

    public Integer getDate() {
        return date;
    }

    public NotificationsComment setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public NotificationsComment setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public NotificationsComment setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Photo getPhoto() {
        return photo;
    }

    public NotificationsComment setPhoto(Photo photo) {
        this.photo = photo;
        return this;
    }

    public Wallpost getPost() {
        return post;
    }

    public NotificationsComment setPost(Wallpost post) {
        this.post = post;
        return this;
    }

    public String getText() {
        return text;
    }

    public NotificationsComment setText(String text) {
        this.text = text;
        return this;
    }

    public Topic getTopic() {
        return topic;
    }

    public NotificationsComment setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public Video getVideo() {
        return video;
    }

    public NotificationsComment setVideo(Video video) {
        this.video = video;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, post, photo, topic, id, text, video, ownerId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationsComment notificationsComment = (NotificationsComment) o;
        return Objects.equals(date, notificationsComment.date) &&
                Objects.equals(post, notificationsComment.post) &&
                Objects.equals(ownerId, notificationsComment.ownerId) &&
                Objects.equals(photo, notificationsComment.photo) &&
                Objects.equals(topic, notificationsComment.topic) &&
                Objects.equals(id, notificationsComment.id) &&
                Objects.equals(text, notificationsComment.text) &&
                Objects.equals(video, notificationsComment.video);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("NotificationsComment{");
        sb.append("date=").append(date);
        sb.append(", post=").append(post);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", photo=").append(photo);
        sb.append(", topic=").append(topic);
        sb.append(", id=").append(id);
        sb.append(", text='").append(text).append("'");
        sb.append(", video=").append(video);
        sb.append('}');
        return sb.toString();
    }
}
