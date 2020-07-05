package com.vk.api.sdk.objects.enums;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum VideoPrivacy implements EnumParam {
    @SerializedName("0")
    ALL("0"),

    @SerializedName("1")
    FRIENDS("1"),

    @SerializedName("2")
    FRIENDS_OF_FRIENDS("2"),

    @SerializedName("3")
    ONLY_ME("3");

    private final String value;

    VideoPrivacy(String value) {
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
