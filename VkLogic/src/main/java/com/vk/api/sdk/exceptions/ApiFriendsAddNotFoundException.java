package com.vk.api.sdk.exceptions;

public class ApiFriendsAddNotFoundException extends ApiException {
    public ApiFriendsAddNotFoundException(String message) {
        super(177, "Cannot add this user to friends as user not found", message);
    }
}
