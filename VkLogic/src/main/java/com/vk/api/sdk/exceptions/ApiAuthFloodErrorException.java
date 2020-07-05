package com.vk.api.sdk.exceptions;

public class ApiAuthFloodErrorException extends ApiException {
    public ApiAuthFloodErrorException(String message) {
        super(1105, "Too many auth attempts, try again later", message);
    }
}
