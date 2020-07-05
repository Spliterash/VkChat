package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

/**
 * Owner type
 */
public enum OwnerXtrBanInfoType implements EnumParam {
    @SerializedName("group")
    GROUP("group"),

    @SerializedName("profile")
    PROFILE("profile");

    private final String value;

    OwnerXtrBanInfoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toLowerCase();
    }
}
