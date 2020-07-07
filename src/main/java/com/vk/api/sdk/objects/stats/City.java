package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * City object
 */
public class City implements Validable {
    /**
     * Visitors number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * City name
     */
    @SerializedName("name")
    private String name;

    /**
     * City ID
     */
    @SerializedName("value")
    private Integer value;

    public Integer getCount() {
        return count;
    }

    public City setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public City setValue(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(count, city.count) &&
                Objects.equals(name, city.name) &&
                Objects.equals(value, city.value);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("count=").append(count);
        sb.append(", name='").append(name).append("'");
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
