package com.vk.api.sdk.exceptions;

public class ApiMessagesChatUserNoAccessException extends ApiException {
    public ApiMessagesChatUserNoAccessException(String message) {
        super(917, "You don't have access to this chat", message);
    }
}
