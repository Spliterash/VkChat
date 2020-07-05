package com.vk.api.sdk.exceptions;

public class ApiMessagesEditExpiredException extends ApiException {
    public ApiMessagesEditExpiredException(String message) {
        super(909, "Can't edit this message, because it's too old", message);
    }
}
