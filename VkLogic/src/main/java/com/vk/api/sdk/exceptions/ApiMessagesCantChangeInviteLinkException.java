package com.vk.api.sdk.exceptions;

public class ApiMessagesCantChangeInviteLinkException extends ApiException {
    public ApiMessagesCantChangeInviteLinkException(String message) {
        super(931, "You can't change invite link for this chat", message);
    }
}
