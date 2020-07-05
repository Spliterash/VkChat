package com.vk.api.sdk.exceptions;

public class ApiMessagesCantDeleteForAllException extends ApiException {
    public ApiMessagesCantDeleteForAllException(String message) {
        super(924, "Can't delete this message for everybody", message);
    }
}
