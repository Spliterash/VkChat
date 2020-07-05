package com.vk.api.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum CallbackServerStatus implements EnumParam {
    @SerializedName("unconfigured")
    UNCONFIGURED("unconfigured"),

    @SerializedName("failed")
    FAILED("failed"),

    @SerializedName("wait")
    WAIT("wait"),

    @SerializedName("ok")
    OK("ok");

    private final String value;

    CallbackServerStatus(String value) {
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
