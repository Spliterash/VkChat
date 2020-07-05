package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsAge object
 */
public class StatsAge implements Validable {
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
     * Age interval
     */
    @SerializedName("value")
    private String value;

    public Float getClicksRate() {
        return clicksRate;
    }

    public StatsAge setClicksRate(Float clicksRate) {
        this.clicksRate = clicksRate;
        return this;
    }

    public Float getImpressionsRate() {
        return impressionsRate;
    }

    public StatsAge setImpressionsRate(Float impressionsRate) {
        this.impressionsRate = impressionsRate;
        return this;
    }

    public String getValue() {
        return value;
    }

    public StatsAge setValue(String value) {
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
        StatsAge statsAge = (StatsAge) o;
        return Objects.equals(impressionsRate, statsAge.impressionsRate) &&
                Objects.equals(value, statsAge.value) &&
                Objects.equals(clicksRate, statsAge.clicksRate);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsAge{");
        sb.append("impressionsRate=").append(impressionsRate);
        sb.append(", value='").append(value).append("'");
        sb.append(", clicksRate=").append(clicksRate);
        sb.append('}');
        return sb.toString();
    }
}
