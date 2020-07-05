package com.vk.api.sdk.objects.callback;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupMarket implements EnumParam {
    @SerializedName("0")
    DISABLED(0),

    @SerializedName("1")
    OPEN(1);

    private final Integer value;

    GroupMarket(Integer value) {
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
