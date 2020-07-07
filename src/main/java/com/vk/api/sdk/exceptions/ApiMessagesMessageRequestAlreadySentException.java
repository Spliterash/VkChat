package com.vk.api.sdk.exceptions;

public class ApiMessagesMessageRequestAlreadySentException extends ApiException {
    public ApiMessagesMessageRequestAlreadySentException(String message) {
        super(939, "Message request already sent", message);
    }
}
