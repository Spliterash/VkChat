package com.vk.api.sdk.exceptions;

public class ApiVideoAlreadyAddedException extends ApiException {
    public ApiVideoAlreadyAddedException(String message) {
        super(800, "This video is already added", message);
    }
}
