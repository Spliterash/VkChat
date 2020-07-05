package com.vk.api.sdk.exceptions;

public class ApiAdsPermissionException extends ApiException {
    public ApiAdsPermissionException(String message) {
        super(600, "Permission denied. You have no access to operations specified with given object(s)", message);
    }
}
