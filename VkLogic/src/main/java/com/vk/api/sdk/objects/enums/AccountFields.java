package com.vk.api.sdk.objects.enums;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum AccountFields implements EnumParam {
    @SerializedName("country")
    COUNTRY("country"),

    @SerializedName("https_required")
    HTTPS_REQUIRED("https_required"),

    @SerializedName("own_posts_default")
    OWN_POSTS_DEFAULT("own_posts_default"),

    @SerializedName("no_wall_replies")
    NO_WALL_REPLIES("no_wall_replies"),

    @SerializedName("intro")
    INTRO("intro"),

    @SerializedName("lang")
    LANG("lang");

    private final String value;

    AccountFields(String value) {
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
