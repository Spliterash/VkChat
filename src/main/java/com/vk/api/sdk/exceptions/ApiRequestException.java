package com.vk.api.sdk.exceptions;

public class ApiRequestException extends ApiException {
    public ApiRequestException(String message) {
        super(8, "Invalid request", message);
    }
}
