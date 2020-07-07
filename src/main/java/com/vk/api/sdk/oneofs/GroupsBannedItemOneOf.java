package com.vk.api.sdk.oneofs;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vk.api.sdk.objects.groups.OwnerXtrBanInfo;

public class GroupsBannedItemOneOf {
    private final JsonObject data;

    private final Gson gson;

    public GroupsBannedItemOneOf(JsonObject data) {
        this.data = data;
        gson = new Gson();
    }

    public JsonObject getRaw() {
        return data;
    }

    public OwnerXtrBanInfo getOneOf0() {
        return gson.fromJson(data.toString(), OwnerXtrBanInfo.class);
    }
}
