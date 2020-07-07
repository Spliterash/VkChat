package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * LinkApplication object
 */
public class LinkApplication implements Validable {
    /**
     * Application Id
     */
    @SerializedName("app_id")
    private Float appId;

    @SerializedName("store")
    private LinkApplicationStore store;

    public Float getAppId() {
        return appId;
    }

    public LinkApplication setAppId(Float appId) {
        this.appId = appId;
        return this;
    }

    public LinkApplicationStore getStore() {
        return store;
    }

    public LinkApplication setStore(LinkApplicationStore store) {
        this.store = store;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, store);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkApplication linkApplication = (LinkApplication) o;
        return Objects.equals(store, linkApplication.store) &&
                Objects.equals(appId, linkApplication.appId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LinkApplication{");
        sb.append("store=").append(store);
        sb.append(", appId=").append(appId);
        sb.append('}');
        return sb.toString();
    }
}
