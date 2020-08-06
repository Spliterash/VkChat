package com.vk.api.sdk.httpclient;

import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.TransportClient;
import lombok.Getter;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.utils.StringUtils;
import sun.net.www.MessageHeader;
import sun.net.www.protocol.https.DelegateHttpsURLConnection;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HttpTransportClient implements TransportClient {

    private static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String USER_AGENT = "Java VK SDK/1.0";

    private static final int DEFAULT_RETRY_ATTEMPTS_NETWORK_ERROR_COUNT = 3;
    private static final int FULL_CONNECTION_TIMEOUT_S = 60;
    private static final int SOCKET_TIMEOUT_MS = FULL_CONNECTION_TIMEOUT_S * 1000;
    @Getter
    private static final HttpTransportClient instance = new HttpTransportClient();

    static {
        CookieHandler empty = new CookieHandler() {
            @Override
            public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) {
                return Collections.emptyMap();
            }

            @Override
            public void put(URI uri, Map<String, List<String>> responseHeaders) {
                //NOTHING
            }
        };
        CookieManager.setDefault(empty);
        CookieHandler.setDefault(empty);
        ResponseCache.setDefault(new ResponseCache() {
            @Override
            public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) {
                return null;
            }

            @Override
            public CacheRequest put(URI uri, URLConnection conn) {
                return null;
            }
        });
    }

    private static HttpURLConnection getConnection(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setReadTimeout(SOCKET_TIMEOUT_MS);
        connection.setDoOutput(true);
        connection.setDefaultUseCaches(false);
        connection.setConnectTimeout(SOCKET_TIMEOUT_MS);
        connection.setRequestProperty(CONTENT_TYPE_HEADER, FORM_CONTENT_TYPE);
        connection.setRequestProperty("User-Agent", USER_AGENT);
        return connection;
    }

    private void call(HttpURLConnection connection) {
        for (int i = 0; i < DEFAULT_RETRY_ATTEMPTS_NETWORK_ERROR_COUNT; i++) {
            try {
                connection.getResponseCode();
                return;
            } catch (IOException ex) {
                VkChat.getLogger().warning(ex.getLocalizedMessage());
            }
        }
        throw new RuntimeException("Retry reached");
    }

    private ClientResponse getResponse(HttpURLConnection connection) throws IOException {
        return new ClientResponse(
                connection.getResponseCode(),
                StringUtils.getString(connection.getInputStream()),
                connection.getHeaderFields()
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue().size() > 0)
                        .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get(0)))
        );
    }

    @Override
    public ClientResponse get(String url) throws IOException {
        HttpURLConnection connection = getConnection(url);
        connection.setRequestMethod("GET");
        call(connection);
        return getResponse(connection);
    }

    private DelegateHttpsURLConnection getDelegate(HttpURLConnection connection) {
        try {
            Field f = connection.getClass().getDeclaredField("delegate");
            f.setAccessible(true);
            return (DelegateHttpsURLConnection) f.get(connection);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public MessageHeader getRequest(DelegateHttpsURLConnection delegate) {
        try {
            Field field = sun.net.www.protocol.http.HttpURLConnection.class.getDeclaredField("requests");
            field.setAccessible(true);
            return (MessageHeader) field.get(delegate);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ClientResponse post(String url, String body) throws IOException {
        HttpURLConnection connection = getConnection(url);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream stream = connection.getOutputStream();
        stream.write(body.getBytes(StandardCharsets.UTF_8));
        call(connection);
        DelegateHttpsURLConnection delegate = getDelegate(connection);
        MessageHeader request = getRequest(delegate);
        Logger log = VkChat.getLogger();
        log.info("-------" + "Request to url: " + url + "-------");
        for (Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
            String logStr = entry.getKey() + ": ";
            List<String> list = entry.getValue();
            if (list.size() == 1)
                log.info(logStr + list.get(0));
            else {
                log.info(": {");
                for (String s : list) {
                    log.info("    " + s);
                }
                log.info("}");
            }
        }
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
}
