package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AddressesInfo object
 */
public class AddressesInfo implements Validable {
    /**
     * Information whether addresses is enabled
     */
    @SerializedName("is_enabled")
    private Boolean isEnabled;

    /**
     * Main address id for group
     */
    @SerializedName("main_address_id")
    private Integer mainAddressId;

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public AddressesInfo setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    public Integer getMainAddressId() {
        return mainAddressId;
    }

    public AddressesInfo setMainAddressId(Integer mainAddressId) {
        this.mainAddressId = mainAddressId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainAddressId, isEnabled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressesInfo addressesInfo = (AddressesInfo) o;
        return Objects.equals(isEnabled, addressesInfo.isEnabled) &&
                Objects.equals(mainAddressId, addressesInfo.mainAddressId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddressesInfo{");
        sb.append("isEnabled=").append(isEnabled);
        sb.append(", mainAddressId=").append(mainAddressId);
        sb.append('}');
        return sb.toString();
    }
}
