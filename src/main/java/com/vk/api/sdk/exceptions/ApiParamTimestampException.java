package com.vk.api.sdk.exceptions;

public class ApiParamTimestampException extends ApiException {
    public ApiParamTimestampException(String message) {
        super(150, "Invalid timestamp", message);
    }
}
