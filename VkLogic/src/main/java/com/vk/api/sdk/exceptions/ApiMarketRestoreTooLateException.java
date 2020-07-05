package com.vk.api.sdk.exceptions;

public class ApiMarketRestoreTooLateException extends ApiException {
    public ApiMarketRestoreTooLateException(String message) {
        super(1400, "Too late for restore", message);
    }
}
