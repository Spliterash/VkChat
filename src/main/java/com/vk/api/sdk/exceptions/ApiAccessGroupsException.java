package com.vk.api.sdk.exceptions;

public class ApiAccessGroupsException extends ApiException {
    public ApiAccessGroupsException(String message) {
        super(260, "Access to the groups list is denied due to the user's privacy settings", message);
    }
}
