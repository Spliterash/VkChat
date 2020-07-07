package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFullMemberStatus;
import java.util.List;
import java.util.Objects;

/**
 * EventActivity object
 */
public class EventActivity implements Validable {
    /**
     * address of event
     */
    @SerializedName("address")
    private String address;

    /**
     * text of attach
     */
    @SerializedName("button_text")
    private String buttonText;

    /**
     * array of friends ids
     */
    @SerializedName("friends")
    @Required
    private List<Integer> friends;

    /**
     * Current user's member status
     */
    @SerializedName("member_status")
    private GroupFullMemberStatus memberStatus;

    /**
     * text of attach
     */
    @SerializedName("text")
    @Required
    private String text;

    /**
     * event start time
     */
    @SerializedName("time")
    private Integer time;

    public String getAddress() {
        return address;
    }

    public EventActivity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getButtonText() {
        return buttonText;
    }

    public EventActivity setButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public EventActivity setFriends(List<Integer> friends) {
        this.friends = friends;
        return this;
    }

    public GroupFullMemberStatus getMemberStatus() {
        return memberStatus;
    }

    public EventActivity setMemberStatus(GroupFullMemberStatus memberStatus) {
        this.memberStatus = memberStatus;
        return this;
    }

    public String getText() {
        return text;
    }

    public EventActivity setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public EventActivity setTime(Integer time) {
        this.time = time;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonText, address, memberStatus, text, time, friends);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventActivity eventActivity = (EventActivity) o;
        return Objects.equals(address, eventActivity.address) &&
                Objects.equals(memberStatus, eventActivity.memberStatus) &&
                Objects.equals(buttonText, eventActivity.buttonText) &&
                Objects.equals(text, eventActivity.text) &&
                Objects.equals(time, eventActivity.time) &&
                Objects.equals(friends, eventActivity.friends);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("EventActivity{");
        sb.append("address='").append(address).append("'");
        sb.append(", memberStatus=").append(memberStatus);
        sb.append(", buttonText='").append(buttonText).append("'");
        sb.append(", text='").append(text).append("'");
        sb.append(", time=").append(time);
        sb.append(", friends=").append(friends);
        sb.append('}');
        return sb.toString();
    }
}
