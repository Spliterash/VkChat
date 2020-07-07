package com.vk.api.sdk.objects.events;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupFullMemberStatus;
import java.util.List;
import java.util.Objects;

/**
 * EventAttach object
 */
public class EventAttach implements Validable {
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
     * event ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * is favorite
     */
    @SerializedName("is_favorite")
    private Boolean isFavorite;

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

    public EventAttach setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getButtonText() {
        return buttonText;
    }

    public EventAttach setButtonText(String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public EventAttach setFriends(List<Integer> friends) {
        this.friends = friends;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public EventAttach setId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public EventAttach setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
        return this;
    }

    public GroupFullMemberStatus getMemberStatus() {
        return memberStatus;
    }

    public EventAttach setMemberStatus(GroupFullMemberStatus memberStatus) {
        this.memberStatus = memberStatus;
        return this;
    }

    public String getText() {
        return text;
    }

    public EventAttach setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public EventAttach setTime(Integer time) {
        this.time = time;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buttonText, address, memberStatus, id, text, time, friends, isFavorite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventAttach eventAttach = (EventAttach) o;
        return Objects.equals(address, eventAttach.address) &&
                Objects.equals(isFavorite, eventAttach.isFavorite) &&
                Objects.equals(memberStatus, eventAttach.memberStatus) &&
                Objects.equals(buttonText, eventAttach.buttonText) &&
                Objects.equals(id, eventAttach.id) &&
                Objects.equals(text, eventAttach.text) &&
                Objects.equals(time, eventAttach.time) &&
                Objects.equals(friends, eventAttach.friends);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("EventAttach{");
        sb.append("address='").append(address).append("'");
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", memberStatus=").append(memberStatus);
        sb.append(", buttonText='").append(buttonText).append("'");
        sb.append(", id=").append(id);
        sb.append(", text='").append(text).append("'");
        sb.append(", time=").append(time);
        sb.append(", friends=").append(friends);
        sb.append('}');
        return sb.toString();
    }
}
