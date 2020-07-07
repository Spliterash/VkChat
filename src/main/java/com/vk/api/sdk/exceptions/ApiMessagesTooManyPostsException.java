package com.vk.api.sdk.exceptions;

public class ApiMessagesTooManyPostsException extends ApiException {
    public ApiMessagesTooManyPostsException(String message) {
        super(940, "Too many posts in messages", message);
    }
}
