package com.vk.api.sdk.exceptions;

public class ApiGroupTooManyOfficersException extends ApiException {
    public ApiGroupTooManyOfficersException(String message) {
        super(702, "Too many officers in club", message);
    }
}
