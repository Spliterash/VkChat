package com.vk.api.sdk.exceptions;

public class ApiMarketItemHasBadLinksException extends ApiException {
    public ApiMarketItemHasBadLinksException(String message) {
        super(1408, "Item has bad links in description", message);
    }
}
