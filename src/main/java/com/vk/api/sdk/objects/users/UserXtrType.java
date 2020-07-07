package com.vk.api.sdk.objects.users;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * UserXtrType object
 */
public class UserXtrType extends User implements Validable {
    @SerializedName("type")
    private UserType type;

    public UserType getType() {
        return type;
    }

    public UserXtrType setType(UserType type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserXtrType userXtrType = (UserXtrType) o;
        return Objects.equals(type, userXtrType.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("UserXtrType{");
        sb.append("type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
