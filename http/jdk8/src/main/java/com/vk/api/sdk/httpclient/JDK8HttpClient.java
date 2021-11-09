package com.vk.api.sdk.httpclient;

import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.TransportClient;
import lombok.Getter;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.*;
import java.lang.reflect.Field;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JDK8HttpClient implements TransportClient {

    @Getter
    private static final JDK8HttpClient instance = new JDK8HttpClient();
    /**
     * Поскольку вк шлёт куки, надо создать пустой хандлер
     * А потом через рефлексию его заменять
     * Как по другому не знаю, если кто знает, напишите в вк
     */
    private static final CookieHandler emptyHandler = new CookieHandler() {
        @Override
        public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) {
            return Collections.emptyMap();
        }

        @Override
        public void put(URI uri, Map<String, List<String>> responseHeaders) {
            //NO
        }
    };
    private static final Field delegateField;
    private static final Field cookieHandlerField;

    static {
        try {
            delegateField = HttpsURLConnectionImpl.class.getDeclaredField("delegate");
            cookieHandlerField = sun.net.www.protocol.http.HttpURLConnection.class.getDeclaredField("cookieHandler");
            delegateField.setAccessible(true);
            cookieHandlerField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpURLConnection getConnection(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setReadTimeout(SOCKET_TIMEOUT_MS);
        connection.setDoOutput(true);
        connection.setDefaultUseCaches(false);
        connection.setConnectTimeout(SOCKET_TIMEOUT_MS);
        connection.setRequestProperty(CONTENT_TYPE_HEADER, FORM_CONTENT_TYPE);
        connection.setRequestProperty("User-Agent", USER_AGENT);
        try {
            removeCookieHandler(connection);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void removeCookieHandler(HttpURLConnection connection) throws IllegalAccessException {
        Object delegate = delegateField.get(connection);
        cookieHandlerField.set(delegate, emptyHandler);
    }

    private void call(HttpURLConnection connection) {
        for (int i = 0; i < DEFAULT_RETRY_ATTEMPTS_NETWORK_ERROR_COUNT; i++) {
            try {
                connection.getResponseCode();
                return;
            } catch (IOException ex) {
                Logger.getGlobal().warning(ex.getLocalizedMessage());
            }
        }
        throw new RuntimeException("Retry reached");
    }

    private ClientResponse getResponse(HttpURLConnection connection) throws IOException {
        return new ClientResponse(
                connection.getResponseCode(),
                getString(connection.getInputStream()),
                connection.getHeaderFields()
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue().size() > 0)
                        .collect(Collectors.toMap(e->e.getKey().toLowerCase(), e -> e.getValue().get(0)))
        );
    }

    @Override
    public ClientResponse get(String url) throws IOException {
        HttpURLConnection connection = getConnection(url);
        connection.setRequestMethod("GET");
        call(connection);
        return getResponse(connection);
    }

    @Override
    public ClientResponse post(String url, String body) throws IOException {
        HttpURLConnection connection = getConnection(url);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream stream = connection.getOutputStream();
        stream.write(body.getBytes(StandardCharsets.UTF_8));
        call(connection);
        return getResponse(connection);
    }


    @Override
    public ClientResponse post(String url) throws IOException {
        HttpURLConnection connection = getConnection(url);
        connection.setRequestMethod("POST");
        call(connection);
        return getResponse(connection);
    }

    @Override
    public ClientResponse post(String url, String filename, File file) {
        throw new RuntimeException("Я всё равно не использую эти методы");
    }

    public String getString(InputStream stream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            while (true) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return out.toString();
        }
    }
}
