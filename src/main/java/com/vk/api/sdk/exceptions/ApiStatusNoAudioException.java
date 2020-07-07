package com.vk.api.sdk.exceptions;

public class ApiStatusNoAudioException extends ApiException {
    public ApiStatusNoAudioException(String message) {
        super(221, "User disabled track name broadcast", message);
    }
}
