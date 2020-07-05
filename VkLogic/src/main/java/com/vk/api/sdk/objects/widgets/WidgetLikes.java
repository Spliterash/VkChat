package com.vk.api.sdk.objects.widgets;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * WidgetLikes object
 */
public class WidgetLikes implements Validable {
    /**
     * Likes number
     */
    @SerializedName("count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public WidgetLikes setCount(Integer count) {
        this.count = count;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WidgetLikes widgetLikes = (WidgetLikes) o;
        return Objects.equals(count, widgetLikes.count);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("WidgetLikes{");
        sb.append("count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
