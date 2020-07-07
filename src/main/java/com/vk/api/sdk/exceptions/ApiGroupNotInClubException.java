package com.vk.api.sdk.exceptions;

public class ApiGroupNotInClubException extends ApiException {
    public ApiGroupNotInClubException(String message) {
        super(701, "User should be in club", message);
    }
}
