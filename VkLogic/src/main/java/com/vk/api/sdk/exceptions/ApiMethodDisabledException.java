package com.vk.api.sdk.exceptions;

public class ApiMethodDisabledException extends ApiException {
    public ApiMethodDisabledException(String message) {
        super(23, "This method was disabled", message);
    }
}
