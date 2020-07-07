package com.vk.api.sdk.objects.friends;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.users.UserFull;
import java.util.Objects;

/**
 * UserXtrPhone object
 */
public class UserXtrPhone extends UserFull implements Validable {
    /**
     * User phone
     */
    @SerializedName("phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public UserXtrPhone setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserXtrPhone userXtrPhone = (UserXtrPhone) o;
        return Objects.equals(phone, userXtrPhone.phone);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("UserXtrPhone{");
        sb.append("phone='").append(phone).append("'");
        sb.append('}');
        return sb.toString();
    }
}
