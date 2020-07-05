package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupAgeLimits implements EnumParam {
    @SerializedName("1")
    UNLIMITED(1),

    @SerializedName("2")
    _16_PLUS(2),

    @SerializedName("3")
    _18_PLUS(3);

    private final Integer value;

    GroupAgeLimits(Integer value) {
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
