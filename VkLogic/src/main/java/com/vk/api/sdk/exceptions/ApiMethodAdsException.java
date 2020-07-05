package com.vk.api.sdk.exceptions;

public class ApiMethodAdsException extends ApiException {
    public ApiMethodAdsException(String message) {
        super(21, "Permission to perform this action is allowed only for standalone and OpenAPI applications", message);
    }
}
