package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupFullAgeLimits implements EnumParam {
    @SerializedName("1")
    NO(1),

    @SerializedName("2")
    OVER_16(2),

    @SerializedName("3")
    OVER_18(3);

    private final Integer value;

    GroupFullAgeLimits(Integer value) {
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
