package com.vk.api.sdk.exceptions;

public class ApiMarketGroupingItemsMustHaveDistinctPropertiesException extends ApiException {
    public ApiMarketGroupingItemsMustHaveDistinctPropertiesException(String message) {
        super(1426, "Item must have distinct properties", message);
    }
}
