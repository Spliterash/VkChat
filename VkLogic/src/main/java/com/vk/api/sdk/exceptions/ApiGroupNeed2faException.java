package com.vk.api.sdk.exceptions;

public class ApiGroupNeed2faException extends ApiException {
    public ApiGroupNeed2faException(String message) {
        super(703, "You need to enable 2FA for this action", message);
    }
}
