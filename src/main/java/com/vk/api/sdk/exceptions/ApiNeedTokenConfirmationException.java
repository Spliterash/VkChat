package com.vk.api.sdk.exceptions;

public class ApiNeedTokenConfirmationException extends ApiException {
    public ApiNeedTokenConfirmationException(String message) {
        super(25, "Token confirmation required", message);
    }
}
