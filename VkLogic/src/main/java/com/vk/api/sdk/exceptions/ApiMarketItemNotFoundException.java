package com.vk.api.sdk.exceptions;

public class ApiMarketItemNotFoundException extends ApiException {
    public ApiMarketItemNotFoundException(String message) {
        super(1403, "Item not found", message);
    }
}
