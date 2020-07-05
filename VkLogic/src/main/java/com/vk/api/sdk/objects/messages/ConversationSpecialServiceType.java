package com.vk.api.sdk.objects.messages;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum ConversationSpecialServiceType implements EnumParam {
    @SerializedName("business_notify")
    BUSINESS_NOTIFY("business_notify");

    private final String value;

    ConversationSpecialServiceType(String value) {
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
