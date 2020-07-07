package com.vk.api.sdk.objects.database;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Station object
 */
public class Station implements Validable {
    /**
     * City ID
     */
    @SerializedName("city_id")
    private Integer cityId;

    /**
     * Hex color code without #
     */
    @SerializedName("color")
    private String color;

    /**
     * Station ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Station name
     */
    @SerializedName("name")
    @Required
    private String name;

    public Integer getCityId() {
        return cityId;
    }

    public Station setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Station setColor(String color) {
        this.color = color;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Station setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, name, id, cityId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(color, station.color) &&
                Objects.equals(name, station.name) &&
                Objects.equals(id, station.id) &&
                Objects.equals(cityId, station.cityId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Station{");
        sb.append("color='").append(color).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append('}');
        return sb.toString();
    }
}
