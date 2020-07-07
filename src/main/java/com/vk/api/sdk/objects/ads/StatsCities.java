package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsCities object
 */
public class StatsCities implements Validable {
    /**
     * Clicks rate
     */
    @SerializedName("clicks_rate")
    private Float clicksRate;

    /**
     * Impressions rate
     */
    @SerializedName("impressions_rate")
    private Float impressionsRate;

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

    public Float getClicksRate() {
        return clicksRate;
    }

    public StatsCities setClicksRate(Float clicksRate) {
        this.clicksRate = clicksRate;
        return this;
    }

    public Float getImpressionsRate() {
        return impressionsRate;
    }

    public StatsCities setImpressionsRate(Float impressionsRate) {
        this.impressionsRate = impressionsRate;
        return this;
    }

    public String getName() {
        return name;
    }

    public StatsCities setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public StatsCities setValue(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clicksRate, name, impressionsRate, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsCities statsCities = (StatsCities) o;
        return Objects.equals(impressionsRate, statsCities.impressionsRate) &&
                Objects.equals(name, statsCities.name) &&
                Objects.equals(value, statsCities.value) &&
                Objects.equals(clicksRate, statsCities.clicksRate);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsCities{");
        sb.append("impressionsRate=").append(impressionsRate);
        sb.append(", name='").append(name).append("'");
        sb.append(", value=").append(value);
        sb.append(", clicksRate=").append(clicksRate);
        sb.append('}');
        return sb.toString();
    }
}
