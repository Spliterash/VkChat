package com.vk.api.sdk.exceptions;

public class ApiWeightedFloodException extends ApiException {
    public ApiWeightedFloodException(String message) {
        super(601, "Permission denied. You have requested too many actions this day. Try later.", message);
    }
}
