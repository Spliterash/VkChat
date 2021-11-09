package ru.spliterash.vkchat;

import com.vk.api.sdk.client.TransportClient;

import java.lang.reflect.Method;

public class HttpClientFactory {

    public static TransportClient get() {
        double version = Double.parseDouble(System.getProperty("java.specification.version"));

        if (version == 1.8)
            return get("com.vk.api.sdk.httpclient.JDK8HttpClient");
        else if (version > 1.8)
            return get("com.vk.api.sdk.httpclient.JDK11HttpClient");
        else
            throw new RuntimeException("How y launch this lol");
    }

    private static TransportClient get(String className) {
        try {
            Class<?> transportClass = Class.forName(className);

            Method method = transportClass.getMethod("getInstance");

            return (TransportClient) method.invoke(null);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
