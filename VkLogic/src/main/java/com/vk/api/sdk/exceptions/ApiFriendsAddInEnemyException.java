package com.vk.api.sdk.exceptions;

public class ApiFriendsAddInEnemyException extends ApiException {
    public ApiFriendsAddInEnemyException(String message) {
        super(175, "Cannot add this user to friends as they have put you on their blacklist", message);
    }
}
