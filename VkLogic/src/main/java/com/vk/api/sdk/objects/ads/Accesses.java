package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Accesses object
 */
public class Accesses implements Validable {
    /**
     * Client ID
     */
    @SerializedName("client_id")
    private String clientId;

    @SerializedName("role")
    private AccessRole role;

    public String getClientId() {
        return clientId;
    }

    public Accesses setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public AccessRole getRole() {
        return role;
    }

    public Accesses setRole(AccessRole role) {
        this.role = role;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, clientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accesses accesses = (Accesses) o;
        return Objects.equals(role, accesses.role) &&
                Objects.equals(clientId, accesses.clientId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Accesses{");
        sb.append("role=").append(role);
        sb.append(", clientId='").append(clientId).append("'");
        sb.append('}');
        return sb.toString();
    }
}
