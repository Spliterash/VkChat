package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * DemoStats object
 */
public class DemoStats implements Validable {
    /**
     * Object ID
     */
    @SerializedName("id")
    private Integer id;

    @SerializedName("stats")
    private DemostatsFormat stats;

    @SerializedName("type")
    private ObjectType type;

    public Integer getId() {
        return id;
    }

    public DemoStats setId(Integer id) {
        this.id = id;
        return this;
    }

    public DemostatsFormat getStats() {
        return stats;
    }

    public DemoStats setStats(DemostatsFormat stats) {
        this.stats = stats;
        return this;
    }

    public ObjectType getType() {
        return type;
    }

    public DemoStats setType(ObjectType type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stats, id, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoStats demoStats = (DemoStats) o;
        return Objects.equals(stats, demoStats.stats) &&
                Objects.equals(id, demoStats.id) &&
                Objects.equals(type, demoStats.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DemoStats{");
        sb.append("stats=").append(stats);
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
