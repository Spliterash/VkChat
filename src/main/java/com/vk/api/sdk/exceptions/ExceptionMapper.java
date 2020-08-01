package com.vk.api.sdk.exceptions;

import com.vk.api.sdk.objects.base.Error;

public class ExceptionMapper {
    public static ApiException parseException(Error error) {
        if (error.getErrorCode() == 10)
            return new ApiServerException(error.getErrorMsg());
        else
            return new ApiException(error.getErrorCode(), error.getErrorMsg());
    }
}
