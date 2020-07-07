package com.vk.api.sdk.exceptions;

public class ApiTooManyException extends ApiException {
    public ApiTooManyException(String message) {
        super(6, "Too many requests per second", message);
    }
}
