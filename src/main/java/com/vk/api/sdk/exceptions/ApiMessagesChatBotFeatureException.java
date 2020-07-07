package com.vk.api.sdk.exceptions;

public class ApiMessagesChatBotFeatureException extends ApiException {
    public ApiMessagesChatBotFeatureException(String message) {
        super(912, "This is a chat bot feature, change this status in settings", message);
    }
}
