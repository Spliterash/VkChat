package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * UserBlock object
 */
public class UserBlock implements Validable {
    @SerializedName("admin_id")
    private Integer adminId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("unblock_date")
    private Integer unblockDate;

    @SerializedName("reason")
    @Required
    private Integer reason;

    @SerializedName("comment")
    private String comment;

    public Integer getAdminId() {
        return adminId;
    }

    public UserBlock setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserBlock setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUnblockDate() {
        return unblockDate;
    }

    public UserBlock setUnblockDate(Integer unblockDate) {
        this.unblockDate = unblockDate;
        return this;
    }

    public Integer getReason() {
        return reason;
    }

    public UserBlock setReason(Integer reason) {
        this.reason = reason;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public UserBlock setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason, adminId, comment, userId, unblockDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBlock userBlock = (UserBlock) o;
        return Objects.equals(reason, userBlock.reason) &&
                Objects.equals(unblockDate, userBlock.unblockDate) &&
                Objects.equals(userId, userBlock.userId) &&
                Objects.equals(adminId, userBlock.adminId) &&
                Objects.equals(comment, userBlock.comment);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("UserBlock{");
        sb.append("reason=").append(reason);
        sb.append(", unblockDate=").append(unblockDate);
        sb.append(", userId=").append(userId);
        sb.append(", adminId=").append(adminId);
        sb.append(", comment='").append(comment).append("'");
        sb.append('}');
        return sb.toString();
    }
}
