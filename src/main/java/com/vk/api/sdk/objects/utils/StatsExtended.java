package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * StatsExtended object
 */
public class StatsExtended implements Validable {
    @SerializedName("cities")
    private List<StatsCity> cities;

    @SerializedName("countries")
    private List<StatsCountry> countries;

    @SerializedName("sex_age")
    private List<StatsSexAge> sexAge;

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

    public List<StatsCity> getCities() {
        return cities;
    }

    public StatsExtended setCities(List<StatsCity> cities) {
        this.cities = cities;
        return this;
    }

    public List<StatsCountry> getCountries() {
        return countries;
    }

    public StatsExtended setCountries(List<StatsCountry> countries) {
        this.countries = countries;
        return this;
    }

    public List<StatsSexAge> getSexAge() {
        return sexAge;
    }

    public StatsExtended setSexAge(List<StatsSexAge> sexAge) {
        this.sexAge = sexAge;
        return this;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public StatsExtended setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public StatsExtended setViews(Integer views) {
        this.views = views;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities, countries, sexAge, views, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsExtended statsExtended = (StatsExtended) o;
        return Objects.equals(cities, statsExtended.cities) &&
                Objects.equals(countries, statsExtended.countries) &&
                Objects.equals(sexAge, statsExtended.sexAge) &&
                Objects.equals(views, statsExtended.views) &&
                Objects.equals(timestamp, statsExtended.timestamp);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsExtended{");
        sb.append("cities=").append(cities);
        sb.append(", countries=").append(countries);
        sb.append(", sexAge=").append(sexAge);
        sb.append(", views=").append(views);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}
