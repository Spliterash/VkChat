package com.vk.api.sdk.exceptions;

public class ApiSignatureException extends ApiException {
    public ApiSignatureException(String message) {
        super(4, "Incorrect signature", message);
    }
}
