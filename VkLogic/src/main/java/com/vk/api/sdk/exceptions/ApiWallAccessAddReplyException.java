package com.vk.api.sdk.exceptions;

public class ApiWallAccessAddReplyException extends ApiException {
    public ApiWallAccessAddReplyException(String message) {
        super(213, "Access to status replies denied", message);
    }
}
