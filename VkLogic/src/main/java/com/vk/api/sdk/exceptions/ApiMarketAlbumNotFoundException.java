package com.vk.api.sdk.exceptions;

public class ApiMarketAlbumNotFoundException extends ApiException {
    public ApiMarketAlbumNotFoundException(String message) {
        super(1402, "Album not found", message);
    }
}
