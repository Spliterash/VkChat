package com.vk.api.sdk.objects.enums;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum NotesSort implements EnumParam {
    @SerializedName("0")
    _0(0),

    @SerializedName("1")
    _1(1);

    private final Integer value;

    NotesSort(Integer value) {
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
