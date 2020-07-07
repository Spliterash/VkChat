package com.vk.api.sdk.objects.users;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Military object
 */
public class Military implements Validable {
    /**
     * Country ID
     */
    @SerializedName("country_id")
    private Integer countryId;

    /**
     * From year
     */
    @SerializedName("from")
    private Integer from;

    /**
     * Military ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Unit name
     */
    @SerializedName("unit")
    @Required
    private String unit;

    /**
     * Unit ID
     */
    @SerializedName("unit_id")
    private Integer unitId;

    /**
     * Till year
     */
    @SerializedName("until")
    private Integer until;

    public Integer getCountryId() {
        return countryId;
    }

    public Military setCountryId(Integer countryId) {
        this.countryId = countryId;
        return this;
    }

    public Integer getFrom() {
        return from;
    }

    public Military setFrom(Integer from) {
        this.from = from;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Military setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public Military setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public Military setUnitId(Integer unitId) {
        this.unitId = unitId;
        return this;
    }

    public Integer getUntil() {
        return until;
    }

    public Military setUntil(Integer until) {
        this.until = until;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, unitId, from, until, id, countryId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Military military = (Military) o;
        return Objects.equals(unit, military.unit) &&
                Objects.equals(from, military.from) &&
                Objects.equals(until, military.until) &&
                Objects.equals(id, military.id) &&
                Objects.equals(unitId, military.unitId) &&
                Objects.equals(countryId, military.countryId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Military{");
        sb.append("unit='").append(unit).append("'");
        sb.append(", from=").append(from);
        sb.append(", until=").append(until);
        sb.append(", id=").append(id);
        sb.append(", unitId=").append(unitId);
        sb.append(", countryId=").append(countryId);
        sb.append('}');
        return sb.toString();
    }
}
