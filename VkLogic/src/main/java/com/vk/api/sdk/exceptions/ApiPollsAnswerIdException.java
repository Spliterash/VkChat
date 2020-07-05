package com.vk.api.sdk.exceptions;

public class ApiPollsAnswerIdException extends ApiException {
    public ApiPollsAnswerIdException(String message) {
        super(252, "Invalid answer id", message);
    }
}
