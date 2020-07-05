package com.vk.api.sdk.objects.likes;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum Type implements EnumParam {
    @SerializedName("post")
    POST("post"),

    @SerializedName("comment")
    COMMENT("comment"),

    @SerializedName("photo")
    PHOTO("photo"),

    @SerializedName("audio")
    AUDIO("audio"),

    @SerializedName("video")
    VIDEO("video"),

    @SerializedName("note")
    NOTE("note"),

    @SerializedName("market")
    MARKET("market"),

    @SerializedName("photo_comment")
    PHOTO_COMMENT("photo_comment"),

    @SerializedName("video_comment")
    VIDEO_COMMENT("video_comment"),

    @SerializedName("topic_comment")
    TOPIC_COMMENT("topic_comment"),

    @SerializedName("market_comment")
    MARKET_COMMENT("market_comment"),

    @SerializedName("sitepage")
    SITEPAGE("sitepage");

    private final String value;

    Type(String value) {
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
