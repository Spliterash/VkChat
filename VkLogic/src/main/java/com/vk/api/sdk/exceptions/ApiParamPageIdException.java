package com.vk.api.sdk.exceptions;

public class ApiParamPageIdException extends ApiException {
    public ApiParamPageIdException(String message) {
        super(140, "Page not found", message);
    }
}
