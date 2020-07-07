package com.vk.api.sdk.exceptions;

public class ApiGroupChangeCreatorException extends ApiException {
    public ApiGroupChangeCreatorException(String message) {
        super(700, "Cannot edit creator role", message);
    }
}
