package com.vk.api.sdk.exceptions;

public class ApiMarketVariantNotFoundException extends ApiException {
    public ApiMarketVariantNotFoundException(String message) {
        super(1416, "Variant not found", message);
    }
}
