package com.vk.api.sdk.exceptions;

public class ApiParamHashException extends ApiException {
    public ApiParamHashException(String message) {
        super(121, "Invalid hash", message);
    }
}
