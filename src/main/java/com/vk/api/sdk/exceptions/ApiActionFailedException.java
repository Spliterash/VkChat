package com.vk.api.sdk.exceptions;

public class ApiActionFailedException extends ApiException {
    public ApiActionFailedException(String message) {
        super(106, "Unable to process action", message);
    }
}
