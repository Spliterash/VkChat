package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.callback.groups.CallbackGroupSettingsChange;
import com.vk.api.sdk.objects.groups.GroupAudio;
import com.vk.api.sdk.objects.groups.GroupFullAgeLimits;
import com.vk.api.sdk.objects.groups.GroupIsClosed;
import com.vk.api.sdk.objects.groups.GroupPhotos;
import com.vk.api.sdk.objects.groups.GroupVideo;
import com.vk.api.sdk.objects.groups.GroupWall;
import java.util.Objects;

/**
 * GroupSettingsChanges object
 */
public class GroupSettingsChanges implements Validable {
    @SerializedName("title")
    private CallbackGroupSettingsChange<String> title;

    @SerializedName("description")
    private CallbackGroupSettingsChange<String> description;

    @SerializedName("access")
    private CallbackGroupSettingsChange<GroupIsClosed> access;

    @SerializedName("screen_name")
    private CallbackGroupSettingsChange<String> screenName;

    @SerializedName("public_category")
    private CallbackGroupSettingsChange<Integer> publicCategory;

    @SerializedName("public_subcategory")
    private CallbackGroupSettingsChange<Integer> publicSubcategory;

    @SerializedName("age_limits")
    private CallbackGroupSettingsChange<GroupFullAgeLimits> ageLimits;

    @SerializedName("website")
    private CallbackGroupSettingsChange<String> website;

    @SerializedName("enable_status_default")
    private CallbackGroupSettingsChange<GroupWall> enableStatusDefault;

    @SerializedName("enable_audio")
    private CallbackGroupSettingsChange<GroupAudio> enableAudio;

    @SerializedName("enable_video")
    private CallbackGroupSettingsChange<GroupVideo> enableVideo;

    @SerializedName("enable_photo")
    private CallbackGroupSettingsChange<GroupPhotos> enablePhoto;

    @SerializedName("enable_market")
    private CallbackGroupSettingsChange<GroupMarket> enableMarket;

    public CallbackGroupSettingsChange<String> getTitle() {
        return title;
    }

    public GroupSettingsChanges setTitle(CallbackGroupSettingsChange<String> title) {
        this.title = title;
        return this;
    }

    public CallbackGroupSettingsChange<String> getDescription() {
        return description;
    }

    public GroupSettingsChanges setDescription(CallbackGroupSettingsChange<String> description) {
        this.description = description;
        return this;
    }

    public CallbackGroupSettingsChange<GroupIsClosed> getAccess() {
        return access;
    }

    public GroupSettingsChanges setAccess(CallbackGroupSettingsChange<GroupIsClosed> access) {
        this.access = access;
        return this;
    }

    public CallbackGroupSettingsChange<String> getScreenName() {
        return screenName;
    }

    public GroupSettingsChanges setScreenName(CallbackGroupSettingsChange<String> screenName) {
        this.screenName = screenName;
        return this;
    }

    public CallbackGroupSettingsChange<Integer> getPublicCategory() {
        return publicCategory;
    }

    public GroupSettingsChanges setPublicCategory(
            CallbackGroupSettingsChange<Integer> publicCategory) {
        this.publicCategory = publicCategory;
        return this;
    }

    public CallbackGroupSettingsChange<Integer> getPublicSubcategory() {
        return publicSubcategory;
    }

    public GroupSettingsChanges setPublicSubcategory(
            CallbackGroupSettingsChange<Integer> publicSubcategory) {
        this.publicSubcategory = publicSubcategory;
        return this;
    }

    public CallbackGroupSettingsChange<GroupFullAgeLimits> getAgeLimits() {
        return ageLimits;
    }

    public GroupSettingsChanges setAgeLimits(
            CallbackGroupSettingsChange<GroupFullAgeLimits> ageLimits) {
        this.ageLimits = ageLimits;
        return this;
    }

    public CallbackGroupSettingsChange<String> getWebsite() {
        return website;
    }

    public GroupSettingsChanges setWebsite(CallbackGroupSettingsChange<String> website) {
        this.website = website;
        return this;
    }

    public CallbackGroupSettingsChange<GroupWall> getEnableStatusDefault() {
        return enableStatusDefault;
    }

    public GroupSettingsChanges setEnableStatusDefault(
            CallbackGroupSettingsChange<GroupWall> enableStatusDefault) {
        this.enableStatusDefault = enableStatusDefault;
        return this;
    }

    public CallbackGroupSettingsChange<GroupAudio> getEnableAudio() {
        return enableAudio;
    }

    public GroupSettingsChanges setEnableAudio(
            CallbackGroupSettingsChange<GroupAudio> enableAudio) {
        this.enableAudio = enableAudio;
        return this;
    }

    public CallbackGroupSettingsChange<GroupVideo> getEnableVideo() {
        return enableVideo;
    }

    public GroupSettingsChanges setEnableVideo(
            CallbackGroupSettingsChange<GroupVideo> enableVideo) {
        this.enableVideo = enableVideo;
        return this;
    }

    public CallbackGroupSettingsChange<GroupPhotos> getEnablePhoto() {
        return enablePhoto;
    }

    public GroupSettingsChanges setEnablePhoto(
            CallbackGroupSettingsChange<GroupPhotos> enablePhoto) {
        this.enablePhoto = enablePhoto;
        return this;
    }

    public CallbackGroupSettingsChange<GroupMarket> getEnableMarket() {
        return enableMarket;
    }

    public GroupSettingsChanges setEnableMarket(
            CallbackGroupSettingsChange<GroupMarket> enableMarket) {
        this.enableMarket = enableMarket;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, access, description, enableVideo, screenName, title, ageLimits, publicSubcategory, enablePhoto, enableMarket, enableStatusDefault, enableAudio, publicCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupSettingsChanges groupSettingsChanges = (GroupSettingsChanges) o;
        return Objects.equals(enableStatusDefault, groupSettingsChanges.enableStatusDefault) &&
                Objects.equals(website, groupSettingsChanges.website) &&
                Objects.equals(access, groupSettingsChanges.access) &&
                Objects.equals(publicCategory, groupSettingsChanges.publicCategory) &&
                Objects.equals(enableAudio, groupSettingsChanges.enableAudio) &&
                Objects.equals(enableMarket, groupSettingsChanges.enableMarket) &&
                Objects.equals(publicSubcategory, groupSettingsChanges.publicSubcategory) &&
                Objects.equals(description, groupSettingsChanges.description) &&
                Objects.equals(title, groupSettingsChanges.title) &&
                Objects.equals(ageLimits, groupSettingsChanges.ageLimits) &&
                Objects.equals(screenName, groupSettingsChanges.screenName) &&
                Objects.equals(enablePhoto, groupSettingsChanges.enablePhoto) &&
                Objects.equals(enableVideo, groupSettingsChanges.enableVideo);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GroupSettingsChanges{");
        sb.append("enableStatusDefault=").append(enableStatusDefault);
        sb.append(", website='").append(website).append("'");
        sb.append(", access=").append(access);
        sb.append(", publicCategory=").append(publicCategory);
        sb.append(", enableAudio=").append(enableAudio);
        sb.append(", enableMarket=").append(enableMarket);
        sb.append(", publicSubcategory=").append(publicSubcategory);
        sb.append(", description='").append(description).append("'");
        sb.append(", title='").append(title).append("'");
        sb.append(", ageLimits=").append(ageLimits);
        sb.append(", screenName='").append(screenName).append("'");
        sb.append(", enablePhoto=").append(enablePhoto);
        sb.append(", enableVideo=").append(enableVideo);
        sb.append('}');
        return sb.toString();
    }
}
