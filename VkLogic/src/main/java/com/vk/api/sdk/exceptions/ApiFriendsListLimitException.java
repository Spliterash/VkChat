package com.vk.api.sdk.exceptions;

public class ApiFriendsListLimitException extends ApiException {
    public ApiFriendsListLimitException(String message) {
        super(173, "Reached the maximum number of lists", message);
    }
}
