package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsSex object
 */
public class StatsSex implements Validable {
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

    @SerializedName("value")
    private StatsSexValue value;

    public Float getClicksRate() {
        return clicksRate;
    }

    public StatsSex setClicksRate(Float clicksRate) {
        this.clicksRate = clicksRate;
        return this;
    }

    public Float getImpressionsRate() {
        return impressionsRate;
    }

    public StatsSex setImpressionsRate(Float impressionsRate) {
        this.impressionsRate = impressionsRate;
        return this;
    }

    public StatsSexValue getValue() {
        return value;
    }

    public StatsSex setValue(StatsSexValue value) {
        this.value = value;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clicksRate, impressionsRate, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsSex statsSex = (StatsSex) o;
        return Objects.equals(impressionsRate, statsSex.impressionsRate) &&
                Objects.equals(value, statsSex.value) &&
                Objects.equals(clicksRate, statsSex.clicksRate);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsSex{");
        sb.append("impressionsRate=").append(impressionsRate);
        sb.append(", value=").append(value);
        sb.append(", clicksRate=").append(clicksRate);
        sb.append('}');
        return sb.toString();
    }
}
