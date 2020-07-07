package com.vk.api.sdk.exceptions;

public class ApiTooManyListsException extends ApiException {
    public ApiTooManyListsException(String message) {
        super(1170, "Too many feed lists", message);
    }
}
