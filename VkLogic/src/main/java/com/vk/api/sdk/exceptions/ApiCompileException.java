package com.vk.api.sdk.exceptions;

public class ApiCompileException extends ApiException {
    public ApiCompileException(String message) {
        super(12, "Unable to compile code", message);
    }
}
