package com.vk.api.sdk.exceptions;

public class ApiFriendsAddYourselfException extends ApiException {
    public ApiFriendsAddYourselfException(String message) {
        super(174, "Cannot add user himself as friend", message);
    }
}
