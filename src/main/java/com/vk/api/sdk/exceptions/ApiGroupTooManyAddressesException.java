package com.vk.api.sdk.exceptions;

public class ApiGroupTooManyAddressesException extends ApiException {
    public ApiGroupTooManyAddressesException(String message) {
        super(706, "Too many addresses in club", message);
    }
}
