package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * ConversationMember object
 */
public class ConversationMember implements Validable {
    /**
     * Is it possible for user to kick this member
     */
    @SerializedName("can_kick")
    private Boolean canKick;

    @SerializedName("invited_by")
    private Integer invitedBy;

    @SerializedName("is_admin")
    private Boolean isAdmin;

    @SerializedName("is_owner")
    private Boolean isOwner;

    @SerializedName("is_message_request")
    private Boolean isMessageRequest;

    @SerializedName("join_date")
    private Integer joinDate;

    /**
     * Message request date
     */
    @SerializedName("request_date")
    private Integer requestDate;

    @SerializedName("member_id")
    private Integer memberId;

    public Boolean getCanKick() {
        return canKick;
    }

    public ConversationMember setCanKick(Boolean canKick) {
        this.canKick = canKick;
        return this;
    }

    public Integer getInvitedBy() {
        return invitedBy;
    }

    public ConversationMember setInvitedBy(Integer invitedBy) {
        this.invitedBy = invitedBy;
        return this;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public ConversationMember setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public ConversationMember setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
        return this;
    }

    public Boolean getIsMessageRequest() {
        return isMessageRequest;
    }

    public ConversationMember setIsMessageRequest(Boolean isMessageRequest) {
        this.isMessageRequest = isMessageRequest;
        return this;
    }

    public Integer getJoinDate() {
        return joinDate;
    }

    public ConversationMember setJoinDate(Integer joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public Integer getRequestDate() {
        return requestDate;
    }

    public ConversationMember setRequestDate(Integer requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public ConversationMember setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isMessageRequest, joinDate, invitedBy, isOwner, canKick, requestDate, isAdmin, memberId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationMember conversationMember = (ConversationMember) o;
        return Objects.equals(isAdmin, conversationMember.isAdmin) &&
                Objects.equals(memberId, conversationMember.memberId) &&
                Objects.equals(isOwner, conversationMember.isOwner) &&
                Objects.equals(joinDate, conversationMember.joinDate) &&
                Objects.equals(canKick, conversationMember.canKick) &&
                Objects.equals(requestDate, conversationMember.requestDate) &&
                Objects.equals(invitedBy, conversationMember.invitedBy) &&
                Objects.equals(isMessageRequest, conversationMember.isMessageRequest);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ConversationMember{");
        sb.append("isAdmin=").append(isAdmin);
        sb.append(", memberId=").append(memberId);
        sb.append(", isOwner=").append(isOwner);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", canKick=").append(canKick);
        sb.append(", requestDate=").append(requestDate);
        sb.append(", invitedBy=").append(invitedBy);
        sb.append(", isMessageRequest=").append(isMessageRequest);
        sb.append('}');
        return sb.toString();
    }
}
