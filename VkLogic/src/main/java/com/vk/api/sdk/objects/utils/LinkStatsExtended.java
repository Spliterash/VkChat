package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * LinkStatsExtended object
 */
public class LinkStatsExtended implements Validable {
    /**
     * Link key (characters after vk.cc/)
     */
    @SerializedName("key")
    private String key;

    @SerializedName("stats")
    private List<StatsExtended> stats;

    public String getKey() {
        return key;
    }

    public LinkStatsExtended setKey(String key) {
        this.key = key;
        return this;
    }

    public List<StatsExtended> getStats() {
        return stats;
    }

    public LinkStatsExtended setStats(List<StatsExtended> stats) {
        this.stats = stats;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stats, key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkStatsExtended linkStatsExtended = (LinkStatsExtended) o;
        return Objects.equals(stats, linkStatsExtended.stats) &&
                Objects.equals(key, linkStatsExtended.key);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LinkStatsExtended{");
        sb.append("stats=").append(stats);
        sb.append(", key='").append(key).append("'");
        sb.append('}');
        return sb.toString();
    }
}
