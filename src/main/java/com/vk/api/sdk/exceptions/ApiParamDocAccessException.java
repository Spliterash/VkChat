package com.vk.api.sdk.exceptions;

public class ApiParamDocAccessException extends ApiException {
    public ApiParamDocAccessException(String message) {
        super(1153, "Access to document is denied", message);
    }
}
