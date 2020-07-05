package com.vk.api.sdk.objects.ads.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.ads.Category;
import java.util.List;
import java.util.Objects;

/**
 * GetCategoriesResponse object
 */
public class GetCategoriesResponse implements Validable {
    /**
     * Old categories
     */
    @SerializedName("v1")
    private List<Category> v1;

    /**
     * Actual categories
     */
    @SerializedName("v2")
    private List<Category> v2;

    public List<Category> getV1() {
        return v1;
    }

    public GetCategoriesResponse setV1(List<Category> v1) {
        this.v1 = v1;
        return this;
    }

    public List<Category> getV2() {
        return v2;
    }

    public GetCategoriesResponse setV2(List<Category> v2) {
        this.v2 = v2;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCategoriesResponse getCategoriesResponse = (GetCategoriesResponse) o;
        return Objects.equals(v1, getCategoriesResponse.v1) &&
                Objects.equals(v2, getCategoriesResponse.v2);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetCategoriesResponse{");
        sb.append("v1=").append(v1);
        sb.append(", v2=").append(v2);
        sb.append('}');
        return sb.toString();
    }
}
