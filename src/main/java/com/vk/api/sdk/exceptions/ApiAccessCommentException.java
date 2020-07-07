package com.vk.api.sdk.exceptions;

public class ApiAccessCommentException extends ApiException {
    public ApiAccessCommentException(String message) {
        super(183, "Access to comment denied", message);
    }
}
