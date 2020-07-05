package com.vk.api.sdk.exceptions;

public class ApiGroupHostNeed2faException extends ApiException {
    public ApiGroupHostNeed2faException(String message) {
        super(704, "User needs to enable 2FA for this action", message);
    }
}
