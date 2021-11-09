package com.vk.api.sdk.client;

import java.io.File;
import java.io.IOException;

public interface TransportClient {
    String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";
    String CONTENT_TYPE_HEADER = "Content-Type";
    String USER_AGENT = "Java VK SDK/1.0";

    int DEFAULT_RETRY_ATTEMPTS_NETWORK_ERROR_COUNT = 3;
    int FULL_CONNECTION_TIMEOUT_S = 60;
    int SOCKET_TIMEOUT_MS = FULL_CONNECTION_TIMEOUT_S * 1000;

    ClientResponse get(String url) throws IOException;

    ClientResponse post(String url, String body) throws IOException;

    ClientResponse post(String url) throws IOException;

    ClientResponse post(String url, String filename, File file);
}
