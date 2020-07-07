package com.vk.api.sdk.exceptions;

public class ApiMarketTooManyItemsException extends ApiException {
    public ApiMarketTooManyItemsException(String message) {
        super(1405, "Too many items", message);
    }
}
