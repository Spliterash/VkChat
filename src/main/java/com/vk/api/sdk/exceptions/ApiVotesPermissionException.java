package com.vk.api.sdk.exceptions;

public class ApiVotesPermissionException extends ApiException {
    public ApiVotesPermissionException(String message) {
        super(500, "Permission denied. You must enable votes processing in application settings", message);
    }
}
