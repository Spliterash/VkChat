package com.vk.api.sdk.exceptions;

public class ApiMessagesTooBigException extends ApiException {
    public ApiMessagesTooBigException(String message) {
        super(910, "Can't sent this message, because it's too big", message);
    }
}
