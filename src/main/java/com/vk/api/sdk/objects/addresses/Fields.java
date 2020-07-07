package com.vk.api.sdk.objects.addresses;

import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.queries.EnumParam;

public enum Fields implements EnumParam {
    @SerializedName("id")
    ID("id"),

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("address")
    ADDRESS("address"),

    @SerializedName("additional_address")
    ADDITIONAL_ADDRESS("additional_address"),

    @SerializedName("country_id")
    COUNTRY_ID("country_id"),

    @SerializedName("city_id")
    CITY_ID("city_id"),

    @SerializedName("metro_station_id")
    METRO_STATION_ID("metro_station_id"),

    @SerializedName("latitude")
    LATITUDE("latitude"),

    @SerializedName("longitude")
    LONGITUDE("longitude"),

    @SerializedName("distance")
    DISTANCE("distance"),

    @SerializedName("work_info_status")
    WORK_INFO_STATUS("work_info_status"),

    @SerializedName("timetable")
    TIMETABLE("timetable"),

    @SerializedName("phone")
    PHONE("phone"),

    @SerializedName("time_offset")
    TIME_OFFSET("time_offset");

    private final String value;

    Fields(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toLowerCase();
    }
}
