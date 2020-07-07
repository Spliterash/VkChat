package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Stats object
 */
public class Stats implements Validable {
    /**
     * Start time
     */
    @SerializedName("timestamp")
    private Integer timestamp;

    /**
     * Total views number
     */
    @SerializedName("views")
    private Integer views;

    public Integer getTimestamp() {
        return timestamp;
    }

    public Stats setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public Stats setViews(Integer views) {
        this.views = views;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(views, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(views, stats.views) &&
                Objects.equals(timestamp, stats.timestamp);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Stats{");
        sb.append("views=").append(views);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
