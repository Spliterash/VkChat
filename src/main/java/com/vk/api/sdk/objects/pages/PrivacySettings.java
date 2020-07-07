package com.vk.api.sdk.objects.pages;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum PrivacySettings implements EnumParam {
    @SerializedName("0")
    COMMUNITY_MANAGERS_ONLY(0),

    @SerializedName("1")
    COMMUNITY_MEMBERS_ONLY(1),

    @SerializedName("2")
    EVERYONE(2);

    private final Integer value;

    PrivacySettings(Integer value) {
        this.value = value;
    }

    public String getValue() {
        return value.toString();
    }

    @Override
    public String toString() {
        return value.toString().toLowerCase();
    }
}
