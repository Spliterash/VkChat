package com.vk.api.sdk.exceptions;

public class ApiMethodPermissionException extends ApiException {
    public ApiMethodPermissionException(String message) {
        super(20, "Permission to perform this action is denied for non-standalone applications", message);
    }
}
