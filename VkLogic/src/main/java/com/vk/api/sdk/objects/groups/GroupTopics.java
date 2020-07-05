package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum GroupTopics implements EnumParam {
    @SerializedName("0")
    DISABLED(0),

    @SerializedName("1")
    OPEN(1),

    @SerializedName("2")
    LIMITED(2);

    private final Integer value;

    GroupTopics(Integer value) {
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
