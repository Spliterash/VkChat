package com.vk.api.sdk.objects.account.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * ChangePasswordResponse object
 */
public class ChangePasswordResponse implements Validable {
    /**
     * New token
     */
    @SerializedName("token")
    @Required
    private String token;

    /**
     * New secret
     */
    @SerializedName("secret")
    private String secret;

    public String getToken() {
        return token;
    }

    public ChangePasswordResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public ChangePasswordResponse setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secret, token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangePasswordResponse changePasswordResponse = (ChangePasswordResponse) o;
        return Objects.equals(secret, changePasswordResponse.secret) &&
                Objects.equals(token, changePasswordResponse.token);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ChangePasswordResponse{");
        sb.append("secret='").append(secret).append("'");
        sb.append(", token='").append(token).append("'");
        sb.append('}');
        return sb.toString();
    }
}
