package com.vk.api.sdk.exceptions;

public class ApiParamServerException extends ApiException {
    public ApiParamServerException(String message) {
        super(118, "Invalid server", message);
    }
}
