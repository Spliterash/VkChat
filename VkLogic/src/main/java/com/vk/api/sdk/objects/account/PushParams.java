package com.vk.api.sdk.objects.account;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * PushParams object
 */
public class PushParams implements Validable {
    @SerializedName("msg")
    private List<PushParamsMode> msg;

    @SerializedName("chat")
    private List<PushParamsMode> chat;

    @SerializedName("like")
    private List<PushParamsSettings> like;

    @SerializedName("repost")
    private List<PushParamsSettings> repost;

    @SerializedName("comment")
    private List<PushParamsSettings> comment;

    @SerializedName("mention")
    private List<PushParamsSettings> mention;

    @SerializedName("reply")
    private List<PushParamsOnoff> reply;

    @SerializedName("new_post")
    private List<PushParamsOnoff> newPost;

    @SerializedName("wall_post")
    private List<PushParamsOnoff> wallPost;

    @SerializedName("wall_publish")
    private List<PushParamsOnoff> wallPublish;

    @SerializedName("friend")
    private List<PushParamsOnoff> friend;

    @SerializedName("friend_found")
    private List<PushParamsOnoff> friendFound;

    @SerializedName("friend_accepted")
    private List<PushParamsOnoff> friendAccepted;

    @SerializedName("group_invite")
    private List<PushParamsOnoff> groupInvite;

    @SerializedName("group_accepted")
    private List<PushParamsOnoff> groupAccepted;

    @SerializedName("birthday")
    private List<PushParamsOnoff> birthday;

    @SerializedName("event_soon")
    private List<PushParamsOnoff> eventSoon;

    @SerializedName("app_request")
    private List<PushParamsOnoff> appRequest;

    @SerializedName("sdk_open")
    private List<PushParamsOnoff> sdkOpen;

    public List<PushParamsMode> getMsg() {
        return msg;
    }

    public PushParams setMsg(List<PushParamsMode> msg) {
        this.msg = msg;
        return this;
    }

    public List<PushParamsMode> getChat() {
        return chat;
    }

    public PushParams setChat(List<PushParamsMode> chat) {
        this.chat = chat;
        return this;
    }

    public List<PushParamsSettings> getLike() {
        return like;
    }

    public PushParams setLike(List<PushParamsSettings> like) {
        this.like = like;
        return this;
    }

    public List<PushParamsSettings> getRepost() {
        return repost;
    }

    public PushParams setRepost(List<PushParamsSettings> repost) {
        this.repost = repost;
        return this;
    }

    public List<PushParamsSettings> getComment() {
        return comment;
    }

    public PushParams setComment(List<PushParamsSettings> comment) {
        this.comment = comment;
        return this;
    }

    public List<PushParamsSettings> getMention() {
        return mention;
    }

    public PushParams setMention(List<PushParamsSettings> mention) {
        this.mention = mention;
        return this;
    }

    public List<PushParamsOnoff> getReply() {
        return reply;
    }

    public PushParams setReply(List<PushParamsOnoff> reply) {
        this.reply = reply;
        return this;
    }

    public List<PushParamsOnoff> getNewPost() {
        return newPost;
    }

    public PushParams setNewPost(List<PushParamsOnoff> newPost) {
        this.newPost = newPost;
        return this;
    }

    public List<PushParamsOnoff> getWallPost() {
        return wallPost;
    }

    public PushParams setWallPost(List<PushParamsOnoff> wallPost) {
        this.wallPost = wallPost;
        return this;
    }

    public List<PushParamsOnoff> getWallPublish() {
        return wallPublish;
    }

    public PushParams setWallPublish(List<PushParamsOnoff> wallPublish) {
        this.wallPublish = wallPublish;
        return this;
    }

    public List<PushParamsOnoff> getFriend() {
        return friend;
    }

    public PushParams setFriend(List<PushParamsOnoff> friend) {
        this.friend = friend;
        return this;
    }

    public List<PushParamsOnoff> getFriendFound() {
        return friendFound;
    }

    public PushParams setFriendFound(List<PushParamsOnoff> friendFound) {
        this.friendFound = friendFound;
        return this;
    }

    public List<PushParamsOnoff> getFriendAccepted() {
        return friendAccepted;
    }

    public PushParams setFriendAccepted(List<PushParamsOnoff> friendAccepted) {
        this.friendAccepted = friendAccepted;
        return this;
    }

    public List<PushParamsOnoff> getGroupInvite() {
        return groupInvite;
    }

    public PushParams setGroupInvite(List<PushParamsOnoff> groupInvite) {
        this.groupInvite = groupInvite;
        return this;
    }

    public List<PushParamsOnoff> getGroupAccepted() {
        return groupAccepted;
    }

    public PushParams setGroupAccepted(List<PushParamsOnoff> groupAccepted) {
        this.groupAccepted = groupAccepted;
        return this;
    }

    public List<PushParamsOnoff> getBirthday() {
        return birthday;
    }

    public PushParams setBirthday(List<PushParamsOnoff> birthday) {
        this.birthday = birthday;
        return this;
    }

    public List<PushParamsOnoff> getEventSoon() {
        return eventSoon;
    }

    public PushParams setEventSoon(List<PushParamsOnoff> eventSoon) {
        this.eventSoon = eventSoon;
        return this;
    }

    public List<PushParamsOnoff> getAppRequest() {
        return appRequest;
    }

    public PushParams setAppRequest(List<PushParamsOnoff> appRequest) {
        this.appRequest = appRequest;
        return this;
    }

    public List<PushParamsOnoff> getSdkOpen() {
        return sdkOpen;
    }

    public PushParams setSdkOpen(List<PushParamsOnoff> sdkOpen) {
        this.sdkOpen = sdkOpen;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg, birthday, wallPost, appRequest, groupAccepted, friendAccepted, like, eventSoon, mention, wallPublish, chat, groupInvite, friend, friendFound, newPost, comment, reply, sdkOpen, repost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushParams pushParams = (PushParams) o;
        return Objects.equals(msg, pushParams.msg) &&
                Objects.equals(birthday, pushParams.birthday) &&
                Objects.equals(wallPublish, pushParams.wallPublish) &&
                Objects.equals(friendAccepted, pushParams.friendAccepted) &&
                Objects.equals(like, pushParams.like) &&
                Objects.equals(wallPost, pushParams.wallPost) &&
                Objects.equals(newPost, pushParams.newPost) &&
                Objects.equals(appRequest, pushParams.appRequest) &&
                Objects.equals(eventSoon, pushParams.eventSoon) &&
                Objects.equals(mention, pushParams.mention) &&
                Objects.equals(groupAccepted, pushParams.groupAccepted) &&
                Objects.equals(sdkOpen, pushParams.sdkOpen) &&
                Objects.equals(chat, pushParams.chat) &&
                Objects.equals(friend, pushParams.friend) &&
                Objects.equals(comment, pushParams.comment) &&
                Objects.equals(reply, pushParams.reply) &&
                Objects.equals(friendFound, pushParams.friendFound) &&
                Objects.equals(groupInvite, pushParams.groupInvite) &&
                Objects.equals(repost, pushParams.repost);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PushParams{");
        sb.append("msg=").append(msg);
        sb.append(", birthday=").append(birthday);
        sb.append(", wallPublish=").append(wallPublish);
        sb.append(", friendAccepted=").append(friendAccepted);
        sb.append(", like=").append(like);
        sb.append(", wallPost=").append(wallPost);
        sb.append(", newPost=").append(newPost);
        sb.append(", appRequest=").append(appRequest);
        sb.append(", eventSoon=").append(eventSoon);
        sb.append(", mention=").append(mention);
        sb.append(", groupAccepted=").append(groupAccepted);
        sb.append(", sdkOpen=").append(sdkOpen);
        sb.append(", chat=").append(chat);
        sb.append(", friend=").append(friend);
        sb.append(", comment=").append(comment);
        sb.append(", reply=").append(reply);
        sb.append(", friendFound=").append(friendFound);
        sb.append(", groupInvite=").append(groupInvite);
        sb.append(", repost=").append(repost);
        sb.append('}');
        return sb.toString();
    }
}
