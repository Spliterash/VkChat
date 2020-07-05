package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * GroupOfficersEdit object
 */
public class GroupOfficersEdit implements Validable {
    @SerializedName("admin_id")
    private Integer adminId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("level_old")
    private GroupOfficerRole levelOld;

    @SerializedName("level_new")
    private GroupOfficerRole levelNew;

    public Integer getAdminId() {
        return adminId;
    }

    public GroupOfficersEdit setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public GroupOfficersEdit setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public GroupOfficerRole getLevelOld() {
        return levelOld;
    }

    public GroupOfficersEdit setLevelOld(GroupOfficerRole levelOld) {
        this.levelOld = levelOld;
        return this;
    }

    public GroupOfficerRole getLevelNew() {
        return levelNew;
    }

    public GroupOfficersEdit setLevelNew(GroupOfficerRole levelNew) {
        this.levelNew = levelNew;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(levelOld, adminId, userId, levelNew);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupOfficersEdit groupOfficersEdit = (GroupOfficersEdit) o;
        return Objects.equals(levelOld, groupOfficersEdit.levelOld) &&
                Objects.equals(userId, groupOfficersEdit.userId) &&
                Objects.equals(adminId, groupOfficersEdit.adminId) &&
                Objects.equals(levelNew, groupOfficersEdit.levelNew);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GroupOfficersEdit{");
        sb.append("levelOld=").append(levelOld);
        sb.append(", userId=").append(userId);
        sb.append(", adminId=").append(adminId);
        sb.append(", levelNew=").append(levelNew);
        sb.append('}');
        return sb.toString();
    }
}
