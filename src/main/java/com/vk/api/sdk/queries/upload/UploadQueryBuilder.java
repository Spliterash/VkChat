package com.vk.api.sdk.queries.upload;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.vk.api.sdk.client.ApiRequest;
import com.vk.api.sdk.client.ClientResponse;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.exceptions.UploadException;
import ru.spliterash.vkchat.VkChat;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.logging.Logger;

public abstract class UploadQueryBuilder<T, R> extends ApiRequest<R> {

    private static final Logger LOG = VkChat.getLogger();

    private final String filename;

    private File file;

    public UploadQueryBuilder(VkApiClient client, String uploadUrl, String filename, Type type) {
        super(uploadUrl, client.getTransportClient(), client.getGson(), 0, type);
        this.filename = filename;
    }

    public T file(File value) {
        file = value;
        return getThis();
    }

    protected abstract T getThis();

    @Override
    public R execute() throws ApiException, ClientException {
        String textResponse = executeAsString();
        JsonReader jsonReader = new JsonReader(new StringReader(textResponse));
        JsonObject json = (JsonObject) new JsonParser().parse(jsonReader);

        if (json.has("error")) {
            UploadException uploadException = new UploadException(0, textResponse, "");
            LOG.warning("API error");
            throw uploadException;
        }

        try {
            return getGson().fromJson(json, getResponseClass());
        } catch (JsonSyntaxException e) {
            LOG.warning("Invalid JSON: " + textResponse);
            throw new ClientException("Can't parse json response");
        }
    }

    @Override
    public String executeAsString() throws ClientException {
        ClientResponse response;
        try {
            if (file != null) {
                response = getClient()
                        .post(getUrl(), filename, file);
            } else {
                response = getClient().post(getUrl());
            }
        } catch (IOException e) {
            LOG.warning("Problems with request: " + getUrl());
            throw new ClientException("I/O exception");
        }

        if (response.getStatusCode() != 200) {
            LOG.warning("Invalid HTTP status " + response.getStatusCode() + " from " + getUrl());
            throw new ClientException("Internal API server error");
        }

        return response.getContent();
    }

    @Override
    protected String getBody() {
        throw new UnsupportedOperationException("not supported");
    }
}
