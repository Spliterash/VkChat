package com.vk.api.sdk.exceptions;

public class ApiWallAddPostException extends ApiException {
    public ApiWallAddPostException(String message) {
        super(214, "Access to adding post denied", message);
    }
}
