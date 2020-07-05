package com.vk.api.sdk.objects.callback;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupJoinType implements EnumParam {
    @SerializedName("join")
    JOIN("join"),

    @SerializedName("unsure")
    UNSURE("unsure"),

    @SerializedName("accepted")
    ACCEPTED("accepted"),

    @SerializedName("approved")
    APPROVED("approved"),

    @SerializedName("request")
    REQUEST("request");

    private final String value;

    GroupJoinType(String value) {
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
