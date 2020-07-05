package com.vk.api.sdk.objects.utils.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.utils.LastShortenedLink;
import java.util.List;
import java.util.Objects;

/**
 * GetLastShortenedLinksResponse object
 */
public class GetLastShortenedLinksResponse implements Validable {
    /**
     * Total number of available results
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("items")
    private List<LastShortenedLink> items;

    public Integer getCount() {
        return count;
    }

    public GetLastShortenedLinksResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<LastShortenedLink> getItems() {
        return items;
    }

    public GetLastShortenedLinksResponse setItems(List<LastShortenedLink> items) {
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
        GetLastShortenedLinksResponse getLastShortenedLinksResponse = (GetLastShortenedLinksResponse) o;
        return Objects.equals(count, getLastShortenedLinksResponse.count) &&
                Objects.equals(items, getLastShortenedLinksResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetLastShortenedLinksResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
