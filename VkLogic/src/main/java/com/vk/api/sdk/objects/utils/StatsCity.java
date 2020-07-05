package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsCity object
 */
public class StatsCity implements Validable {
    /**
     * City ID
     */
    @SerializedName("city_id")
    private Integer cityId;

    /**
     * Views number
     */
    @SerializedName("views")
    private Integer views;

    public Integer getCityId() {
        return cityId;
    }

    public StatsCity setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public StatsCity setViews(Integer views) {
        this.views = views;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, views);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsCity statsCity = (StatsCity) o;
        return Objects.equals(views, statsCity.views) &&
                Objects.equals(cityId, statsCity.cityId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsCity{");
        sb.append("views=").append(views);
        sb.append(", cityId=").append(cityId);
        sb.append('}');
        return sb.toString();
    }
}
