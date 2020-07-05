package com.vk.api.sdk.objects.database.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.database.University;
import java.util.List;
import java.util.Objects;

/**
 * GetUniversitiesResponse object
 */
public class GetUniversitiesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<University> items;

    public Integer getCount() {
        return count;
    }

    public GetUniversitiesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<University> getItems() {
        return items;
    }

    public GetUniversitiesResponse setItems(List<University> items) {
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
        GetUniversitiesResponse getUniversitiesResponse = (GetUniversitiesResponse) o;
        return Objects.equals(count, getUniversitiesResponse.count) &&
                Objects.equals(items, getUniversitiesResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetUniversitiesResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
