package com.vk.api.sdk.objects.apps.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.apps.Scope;
import java.util.List;
import java.util.Objects;

/**
 * GetScopesResponse object
 */
public class GetScopesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Scope> items;

    public Integer getCount() {
        return count;
    }

    public GetScopesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Scope> getItems() {
        return items;
    }

    public GetScopesResponse setItems(List<Scope> items) {
        this.items = items;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetScopesResponse getScopesResponse = (GetScopesResponse) o;
        return Objects.equals(count, getScopesResponse.count) &&
                Objects.equals(items, getScopesResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetScopesResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
