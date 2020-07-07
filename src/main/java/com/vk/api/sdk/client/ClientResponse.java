package com.vk.api.sdk.client;

import java.util.Map;

/**
 * Created by Anton Tsivarev on 11.09.15.
 */
public class ClientResponse {

    private final int statusCode;

    private final String content;

    private final Map<String, String> headers;

    public ClientResponse(int statusCode, String content, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.content = content;
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getContent() {
        return content;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
