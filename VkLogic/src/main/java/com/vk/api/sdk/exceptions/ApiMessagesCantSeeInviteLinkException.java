package com.vk.api.sdk.exceptions;

public class ApiMessagesCantSeeInviteLinkException extends ApiException {
    public ApiMessagesCantSeeInviteLinkException(String message) {
        super(919, "You can't see invite link for this chat", message);
    }
}
