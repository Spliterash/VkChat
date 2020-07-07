package com.vk.api.sdk.exceptions;

public class ApiGroupAuthException extends ApiException {
    public ApiGroupAuthException(String message) {
        super(27, "Group authorization failed", message);
    }
}
