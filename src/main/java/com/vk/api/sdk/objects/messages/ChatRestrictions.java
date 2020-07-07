package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * ChatRestrictions object
 */
public class ChatRestrictions implements Validable {
    /**
     * Only admins can promote users to admins
     */
    @SerializedName("admins_promote_users")
    private Boolean adminsPromoteUsers;

    /**
     * Only admins can change chat info
     */
    @SerializedName("only_admins_edit_info")
    private Boolean onlyAdminsEditInfo;

    /**
     * Only admins can edit pinned message
     */
    @SerializedName("only_admins_edit_pin")
    private Boolean onlyAdminsEditPin;

    /**
     * Only admins can invite users to this chat
     */
    @SerializedName("only_admins_invite")
    private Boolean onlyAdminsInvite;

    /**
     * Only admins can kick users from this chat
     */
    @SerializedName("only_admins_kick")
    private Boolean onlyAdminsKick;

    public Boolean getAdminsPromoteUsers() {
        return adminsPromoteUsers;
    }

    public ChatRestrictions setAdminsPromoteUsers(Boolean adminsPromoteUsers) {
        this.adminsPromoteUsers = adminsPromoteUsers;
        return this;
    }

    public Boolean getOnlyAdminsEditInfo() {
        return onlyAdminsEditInfo;
    }

    public ChatRestrictions setOnlyAdminsEditInfo(Boolean onlyAdminsEditInfo) {
        this.onlyAdminsEditInfo = onlyAdminsEditInfo;
        return this;
    }

    public Boolean getOnlyAdminsEditPin() {
        return onlyAdminsEditPin;
    }

    public ChatRestrictions setOnlyAdminsEditPin(Boolean onlyAdminsEditPin) {
        this.onlyAdminsEditPin = onlyAdminsEditPin;
        return this;
    }

    public Boolean getOnlyAdminsInvite() {
        return onlyAdminsInvite;
    }

    public ChatRestrictions setOnlyAdminsInvite(Boolean onlyAdminsInvite) {
        this.onlyAdminsInvite = onlyAdminsInvite;
        return this;
    }

    public Boolean getOnlyAdminsKick() {
        return onlyAdminsKick;
    }

    public ChatRestrictions setOnlyAdminsKick(Boolean onlyAdminsKick) {
        this.onlyAdminsKick = onlyAdminsKick;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminsPromoteUsers, onlyAdminsEditInfo, onlyAdminsKick, onlyAdminsEditPin, onlyAdminsInvite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatRestrictions chatRestrictions = (ChatRestrictions) o;
        return Objects.equals(adminsPromoteUsers, chatRestrictions.adminsPromoteUsers) &&
                Objects.equals(onlyAdminsInvite, chatRestrictions.onlyAdminsInvite) &&
                Objects.equals(onlyAdminsEditPin, chatRestrictions.onlyAdminsEditPin) &&
                Objects.equals(onlyAdminsEditInfo, chatRestrictions.onlyAdminsEditInfo) &&
                Objects.equals(onlyAdminsKick, chatRestrictions.onlyAdminsKick);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ChatRestrictions{");
        sb.append("adminsPromoteUsers=").append(adminsPromoteUsers);
        sb.append(", onlyAdminsInvite=").append(onlyAdminsInvite);
        sb.append(", onlyAdminsEditPin=").append(onlyAdminsEditPin);
        sb.append(", onlyAdminsEditInfo=").append(onlyAdminsEditInfo);
        sb.append(", onlyAdminsKick=").append(onlyAdminsKick);
        sb.append('}');
        return sb.toString();
    }
}
