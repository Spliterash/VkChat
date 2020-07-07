package com.vk.api.sdk.exceptions;

public class ApiFriendsAddEnemyException extends ApiException {
    public ApiFriendsAddEnemyException(String message) {
        super(176, "Cannot add this user to friends as you put him on blacklist", message);
    }
}
