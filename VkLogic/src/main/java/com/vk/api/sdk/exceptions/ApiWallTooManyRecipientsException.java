package com.vk.api.sdk.exceptions;

public class ApiWallTooManyRecipientsException extends ApiException {
    public ApiWallTooManyRecipientsException(String message) {
        super(220, "Too many recipients", message);
    }
}
