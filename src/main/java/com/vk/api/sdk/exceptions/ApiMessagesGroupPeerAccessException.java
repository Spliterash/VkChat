package com.vk.api.sdk.exceptions;

public class ApiMessagesGroupPeerAccessException extends ApiException {
    public ApiMessagesGroupPeerAccessException(String message) {
        super(932, "Your community can't interact with this peer", message);
    }
}
