package com.vk.api.sdk.exceptions;

public class ApiMessagesCantFwdException extends ApiException {
    public ApiMessagesCantFwdException(String message) {
        super(921, "Can't forward these messages", message);
    }
}
