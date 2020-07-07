package com.vk.api.sdk.exceptions;

public class ApiMessagesTooNewPtsException extends ApiException {
    public ApiMessagesTooNewPtsException(String message) {
        super(908, "Value of ts or pts is too new", message);
    }
}
