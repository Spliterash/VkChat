package com.vk.api.sdk.exceptions;

public class ApiMarketPropertyNotFoundException extends ApiException {
    public ApiMarketPropertyNotFoundException(String message) {
        super(1417, "Property not found", message);
    }
}
