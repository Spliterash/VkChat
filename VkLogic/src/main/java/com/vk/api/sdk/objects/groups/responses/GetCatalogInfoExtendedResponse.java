package com.vk.api.sdk.objects.groups.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.GroupCategoryFull;
import java.util.List;
import java.util.Objects;

/**
 * GetCatalogInfoExtendedResponse object
 */
public class GetCatalogInfoExtendedResponse implements Validable {
    /**
     * Information whether catalog is enabled for current user
     */
    @SerializedName("enabled")
    @Required
    private Integer enabled;

    @SerializedName("categories")
    private List<GroupCategoryFull> categories;

    public Integer getEnabled() {
        return enabled;
    }

    public GetCatalogInfoExtendedResponse setEnabled(Integer enabled) {
        this.enabled = enabled;
        return this;
    }

    public List<GroupCategoryFull> getCategories() {
        return categories;
    }

    public GetCatalogInfoExtendedResponse setCategories(List<GroupCategoryFull> categories) {
        this.categories = categories;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories, enabled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCatalogInfoExtendedResponse getCatalogInfoExtendedResponse = (GetCatalogInfoExtendedResponse) o;
        return Objects.equals(categories, getCatalogInfoExtendedResponse.categories) &&
                Objects.equals(enabled, getCatalogInfoExtendedResponse.enabled);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCatalogInfoExtendedResponse{");
        sb.append("categories=").append(categories);
        sb.append(", enabled=").append(enabled);
        sb.append('}');
        return sb.toString();
    }
}
