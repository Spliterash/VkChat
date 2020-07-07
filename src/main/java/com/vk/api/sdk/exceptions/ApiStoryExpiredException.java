package com.vk.api.sdk.exceptions;

public class ApiStoryExpiredException extends ApiException {
    public ApiStoryExpiredException(String message) {
        super(1600, "Story has already expired", message);
    }
}
