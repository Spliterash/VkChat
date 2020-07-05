package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * GeoCoordinates object
 */
public class GeoCoordinates implements Validable {
    @SerializedName("latitude")
    @Required
    private Float latitude;

    @SerializedName("longitude")
    @Required
    private Float longitude;

    public Float getLatitude() {
        return latitude;
    }

    public GeoCoordinates setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public GeoCoordinates setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoCoordinates geoCoordinates = (GeoCoordinates) o;
        return Objects.equals(latitude, geoCoordinates.latitude) &&
                Objects.equals(longitude, geoCoordinates.longitude);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GeoCoordinates{");
        sb.append("latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }
}
