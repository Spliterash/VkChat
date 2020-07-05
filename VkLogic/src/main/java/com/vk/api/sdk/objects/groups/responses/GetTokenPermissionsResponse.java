package com.vk.api.sdk.objects.groups.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.TokenPermissionSetting;
import java.util.List;
import java.util.Objects;

/**
 * GetTokenPermissionsResponse object
 */
public class GetTokenPermissionsResponse implements Validable {
    @SerializedName("mask")
    @Required
    private Integer mask;

    @SerializedName("permissions")
    @Required
    private List<TokenPermissionSetting> permissions;

    public Integer getMask() {
        return mask;
    }

    public GetTokenPermissionsResponse setMask(Integer mask) {
        this.mask = mask;
        return this;
    }

    public List<TokenPermissionSetting> getPermissions() {
        return permissions;
    }

    public GetTokenPermissionsResponse setPermissions(List<TokenPermissionSetting> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissions, mask);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTokenPermissionsResponse getTokenPermissionsResponse = (GetTokenPermissionsResponse) o;
        return Objects.equals(permissions, getTokenPermissionsResponse.permissions) &&
                Objects.equals(mask, getTokenPermissionsResponse.mask);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetTokenPermissionsResponse{");
        sb.append("permissions=").append(permissions);
        sb.append(", mask=").append(mask);
        sb.append('}');
        return sb.toString();
    }
}
