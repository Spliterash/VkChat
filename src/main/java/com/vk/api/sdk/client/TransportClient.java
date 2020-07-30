package com.vk.api.sdk.client;

import java.io.File;
import java.io.IOException;

/**
 * Created by tsivarev on 21.07.16.
 */
public interface TransportClient {

    ClientResponse get(String url) throws IOException;

    ClientResponse post(String url, String body) throws IOException;

    ClientResponse post(String url) throws IOException;

    ClientResponse post(String url, String filename, File file);
}
