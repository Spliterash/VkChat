package com.vk.api.sdk.exceptions;

public class ApiParamException extends ApiException {
    public ApiParamException(String message) {
        super(100, "One of the parameters specified was missing or invalid", message);
    }
}
