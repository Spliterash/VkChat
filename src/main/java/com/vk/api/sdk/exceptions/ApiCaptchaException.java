package com.vk.api.sdk.exceptions;

public class ApiCaptchaException extends ApiException {
    public ApiCaptchaException(String message) {
        super(14, "Captcha needed", message);
    }
}
