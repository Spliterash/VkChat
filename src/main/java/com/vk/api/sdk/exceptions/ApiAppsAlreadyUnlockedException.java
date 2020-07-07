package com.vk.api.sdk.exceptions;

public class ApiAppsAlreadyUnlockedException extends ApiException {
    public ApiAppsAlreadyUnlockedException(String message) {
        super(1251, "This achievement is already unlocked", message);
    }
}
