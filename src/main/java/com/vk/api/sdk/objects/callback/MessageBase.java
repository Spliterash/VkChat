package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * MessageBase object
 */
public class MessageBase implements Validable {
    @SerializedName("type")
    @Required
    private MessageType type;

    @SerializedName("object")
    @Required
    private JsonObject object;

    @SerializedName("group_id")
    private Integer groupId;

    public MessageType getType() {
        return type;
    }

    public MessageBase setType(MessageType type) {
        this.type = type;
        return this;
    }

    public JsonObject getObject() {
        return object;
    }

    public MessageBase setObject(JsonObject object) {
        this.object = object;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessageBase setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, type, object);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBase messageBase = (MessageBase) o;
        return Objects.equals(groupId, messageBase.groupId) &&
                Objects.equals(type, messageBase.type) &&
                Objects.equals(object, messageBase.object);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MessageBase{");
        sb.append("groupId=").append(groupId);
        sb.append(", type=").append(type);
        sb.append(", object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}
