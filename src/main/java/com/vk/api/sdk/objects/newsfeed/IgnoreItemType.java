package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum IgnoreItemType implements EnumParam {
    @SerializedName("wall")
    POST_ON_THE_WALL("wall"),

    @SerializedName("tag")
    TAG_ON_A_PHOTO("tag"),

    @SerializedName("profilephoto")
    PROFILE_PHOTO("profilephoto"),

    @SerializedName("video")
    VIDEO("video"),

    @SerializedName("photo")
    PHOTO("photo"),

    @SerializedName("audio")
    AUDIO("audio");

    private final String value;

    IgnoreItemType(String value) {
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
