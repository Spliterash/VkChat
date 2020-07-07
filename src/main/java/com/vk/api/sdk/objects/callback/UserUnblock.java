package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * UserUnblock object
 */
public class UserUnblock implements Validable {
    @SerializedName("admin_id")
    private Integer adminId;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("by_end_date")
    private Integer byEndDate;

    public Integer getAdminId() {
        return adminId;
    }

    public UserUnblock setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserUnblock setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getByEndDate() {
        return byEndDate;
    }

    public UserUnblock setByEndDate(Integer byEndDate) {
        this.byEndDate = byEndDate;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(byEndDate, adminId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUnblock userUnblock = (UserUnblock) o;
        return Objects.equals(byEndDate, userUnblock.byEndDate) &&
                Objects.equals(userId, userUnblock.userId) &&
                Objects.equals(adminId, userUnblock.adminId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("UserUnblock{");
        sb.append("byEndDate=").append(byEndDate);
        sb.append(", userId=").append(userId);
        sb.append(", adminId=").append(adminId);
        sb.append('}');
        return sb.toString();
    }
}
