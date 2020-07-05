package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * ConversationPeer object
 */
public class ConversationPeer implements Validable {
    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("local_id")
    private Integer localId;

    @SerializedName("type")
    @Required
    private ConversationPeerType type;

    public Integer getId() {
        return id;
    }

    public ConversationPeer setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getLocalId() {
        return localId;
    }

    public ConversationPeer setLocalId(Integer localId) {
        this.localId = localId;
        return this;
    }

    public ConversationPeerType getType() {
        return type;
    }

    public ConversationPeer setType(ConversationPeerType type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, localId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationPeer conversationPeer = (ConversationPeer) o;
        return Objects.equals(localId, conversationPeer.localId) &&
                Objects.equals(id, conversationPeer.id) &&
                Objects.equals(type, conversationPeer.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ConversationPeer{");
        sb.append("localId=").append(localId);
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
