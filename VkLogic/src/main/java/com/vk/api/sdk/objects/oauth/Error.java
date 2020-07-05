package com.vk.api.sdk.objects.oauth;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Error object
 */
public class Error implements Validable {
    /**
     * Error type
     */
    @SerializedName("error")
    @Required
    private String error;

    /**
     * Error description
     */
    @SerializedName("error_description")
    private String errorDescription;

    /**
     * URI for validation
     */
    @SerializedName("redirect_uri")
    private String redirectUri;

    public String getError() {
        return error;
    }

    public Error setError(String error) {
        this.error = error;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Error setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public Error setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(redirectUri, errorDescription, error);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(errorDescription, error.errorDescription) &&
                Objects.equals(redirectUri, error.redirectUri) &&
                Objects.equals(error, error.error);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Error{");
        sb.append("errorDescription='").append(errorDescription).append("'");
        sb.append(", redirectUri='").append(redirectUri).append("'");
        sb.append(", error='").append(error).append("'");
        sb.append('}');
        return sb.toString();
    }
}
