package com.vk.api.sdk.exceptions;

public class ApiDisabledException extends ApiException {
    public ApiDisabledException(String message) {
        super(2, "Application is disabled. Enable your application or use test mode", message);
    }
}
