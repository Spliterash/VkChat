package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupAccess implements EnumParam {
    @SerializedName("0")
    OPEN(0),

    @SerializedName("1")
    CLOSED(1),

    @SerializedName("2")
    PRIVATE(2);

    private final Integer value;

    GroupAccess(Integer value) {
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
