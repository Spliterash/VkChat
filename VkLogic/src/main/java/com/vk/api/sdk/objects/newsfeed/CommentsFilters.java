package com.vk.api.sdk.objects.newsfeed;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum CommentsFilters implements EnumParam {
    @SerializedName("post")
    POST("post"),

    @SerializedName("photo")
    PHOTO("photo"),

    @SerializedName("video")
    VIDEO("video"),

    @SerializedName("topic")
    TOPIC("topic"),

    @SerializedName("note")
    NOTE("note");

    private final String value;

    CommentsFilters(String value) {
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
