package com.vk.api.sdk.httpclient;

import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.TransportClient;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JDK11HttpClient implements TransportClient {
    @Getter
    private static final JDK11HttpClient instance = new JDK11HttpClient();
    private final HttpClient client;

    private JDK11HttpClient() {
        client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(FULL_CONNECTION_TIMEOUT_S))
                .cookieHandler(new CookieHandler() {
                    @Override
                    public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
                        return new HashMap<>();
                    }

                    @Override
                    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
                        // F***** NOTHING
                    }
                })
                .build();
    }

    @SneakyThrows
    @Override
    public ClientResponse get(String url) throws IOException {
        return execute(HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
        );
    }

    @SneakyThrows
    @Override
    public ClientResponse post(String url, String body) throws IOException {
        return execute(HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(body))
        );
    }

    @SneakyThrows
    @Override
    public ClientResponse post(String url) throws IOException {
        return execute(HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.noBody())
        );
    }

    @SneakyThrows
    @Override
    public ClientResponse post(String url, String filename, File file) {
        return execute(HttpRequest.newBuilder()
                .uri(new URI(url))
                .header(CONTENT_TYPE_HEADER, FORM_CONTENT_TYPE)
                .POST(HttpRequest.BodyPublishers.ofFile(file.toPath()))
        );
    }

    private ClientResponse execute(HttpRequest.Builder builder) throws InterruptedException {
        HttpRequest request = builder
                .header(CONTENT_TYPE_HEADER, FORM_CONTENT_TYPE)
                .header("User-Agent", USER_AGENT)
                .build();

        for (int i = 0; i < DEFAULT_RETRY_ATTEMPTS_NETWORK_ERROR_COUNT; i++) {
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return new ClientResponse(
                        response.statusCode(),
                        response.body(),
                        response.headers()
                                .map()
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(e -> e.getKey().toLowerCase(), e -> e.getValue().size() > 0 ? e.getValue().get(0) : ""))
                );
            } catch (IOException ex) {
                Logger.getGlobal().warning(ex.getLocalizedMessage());
            }
        }
        throw new RuntimeException("Retry reached");

    }
}
