package com.vk.api.sdk.objects.widgets.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.widgets.WidgetPage;
import java.util.List;
import java.util.Objects;

/**
 * GetPagesResponse object
 */
public class GetPagesResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("pages")
    @Required
    private List<WidgetPage> pages;

    public Integer getCount() {
        return count;
    }

    public GetPagesResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<WidgetPage> getPages() {
        return pages;
    }

    public GetPagesResponse setPages(List<WidgetPage> pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetPagesResponse getPagesResponse = (GetPagesResponse) o;
        return Objects.equals(pages, getPagesResponse.pages) &&
                Objects.equals(count, getPagesResponse.count);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetPagesResponse{");
        sb.append("pages=").append(pages);
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
