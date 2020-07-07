package com.vk.api.sdk.exceptions;

public class ApiMessagesEditKindDisallowedException extends ApiException {
    public ApiMessagesEditKindDisallowedException(String message) {
        super(920, "Can't edit this kind of message", message);
    }
}
