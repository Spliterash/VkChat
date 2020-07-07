package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Country object
 */
public class Country implements Validable {
    /**
     * Country code
     */
    @SerializedName("code")
    private String code;

    /**
     * Visitors number
     */
    @SerializedName("count")
    private Integer count;

    /**
     * Country name
     */
    @SerializedName("name")
    private String name;

    /**
     * Country ID
     */
    @SerializedName("value")
    private Integer value;

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Country setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public Country setValue(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, count, name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) &&
                Objects.equals(count, country.count) &&
                Objects.equals(name, country.name) &&
                Objects.equals(value, country.value);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("code='").append(code).append("'");
        sb.append(", count=").append(count);
        sb.append(", name='").append(name).append("'");
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
