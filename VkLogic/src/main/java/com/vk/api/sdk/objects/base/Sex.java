package com.vk.api.sdk.objects.base;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum Sex implements EnumParam {
    @SerializedName("0")
    UNKNOWN(0),

    @SerializedName("1")
    FEMALE(1),

    @SerializedName("2")
    MALE(2);

    private final Integer value;

    Sex(Integer value) {
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
