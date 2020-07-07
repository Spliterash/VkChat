package com.vk.api.sdk.exceptions;

public class ApiMessagesChatNotAdminException extends ApiException {
    public ApiMessagesChatNotAdminException(String message) {
        super(925, "You are not admin of this chat", message);
    }
}
