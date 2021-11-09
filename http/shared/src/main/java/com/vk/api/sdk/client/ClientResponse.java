package com.vk.api.sdk.client;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;

@Getter
public class ClientResponse {
    private final int statusCode;
    private final String content;
    @Getter(AccessLevel.NONE)
    private final Map<String, String> headers;

    public ClientResponse(int statusCode, String content, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.content = content;
        this.headers = headers;
    }

    public String getHeader(String key) {
        return headers.get(key.toLowerCase());
    }
}
