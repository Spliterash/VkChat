package com.vk.api.sdk.exceptions;

public class ApiMethodException extends ApiException {
    public ApiMethodException(String message) {
        super(3, "Unknown method passed", message);
    }
}
