package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsCountry object
 */
public class StatsCountry implements Validable {
    /**
     * Country ID
     */
    @SerializedName("country_id")
    private Integer countryId;

    /**
     * Views number
     */
    @SerializedName("views")
    private Integer views;

    public Integer getCountryId() {
        return countryId;
    }

    public StatsCountry setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public StatsCountry setViews(Integer views) {
        this.views = views;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, views);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsCountry statsCountry = (StatsCountry) o;
        return Objects.equals(countryId, statsCountry.countryId) &&
                Objects.equals(views, statsCountry.views);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsCountry{");
        sb.append("countryId=").append(countryId);
        sb.append(", views=").append(views);
        sb.append('}');
        return sb.toString();
    }
}
