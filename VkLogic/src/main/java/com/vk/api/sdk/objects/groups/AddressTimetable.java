package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Timetable for a week
 */
public class AddressTimetable implements Validable {
    /**
     * Timetable for friday
     */
    @SerializedName("fri")
    private AddressTimetableDay fri;

    /**
     * Timetable for monday
     */
    @SerializedName("mon")
    private AddressTimetableDay mon;

    /**
     * Timetable for saturday
     */
    @SerializedName("sat")
    private AddressTimetableDay sat;

    /**
     * Timetable for sunday
     */
    @SerializedName("sun")
    private AddressTimetableDay sun;

    /**
     * Timetable for thursday
     */
    @SerializedName("thu")
    private AddressTimetableDay thu;

    /**
     * Timetable for tuesday
     */
    @SerializedName("tue")
    private AddressTimetableDay tue;

    /**
     * Timetable for wednesday
     */
    @SerializedName("wed")
    private AddressTimetableDay wed;

    public AddressTimetableDay getFri() {
        return fri;
    }

    public AddressTimetable setFri(AddressTimetableDay fri) {
        this.fri = fri;
        return this;
    }

    public AddressTimetableDay getMon() {
        return mon;
    }

    public AddressTimetable setMon(AddressTimetableDay mon) {
        this.mon = mon;
        return this;
    }

    public AddressTimetableDay getSat() {
        return sat;
    }

    public AddressTimetable setSat(AddressTimetableDay sat) {
        this.sat = sat;
        return this;
    }

    public AddressTimetableDay getSun() {
        return sun;
    }

    public AddressTimetable setSun(AddressTimetableDay sun) {
        this.sun = sun;
        return this;
    }

    public AddressTimetableDay getThu() {
        return thu;
    }

    public AddressTimetable setThu(AddressTimetableDay thu) {
        this.thu = thu;
        return this;
    }

    public AddressTimetableDay getTue() {
        return tue;
    }

    public AddressTimetable setTue(AddressTimetableDay tue) {
        this.tue = tue;
        return this;
    }

    public AddressTimetableDay getWed() {
        return wed;
    }

    public AddressTimetable setWed(AddressTimetableDay wed) {
        this.wed = wed;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(thu, tue, sat, wed, fri, mon, sun);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressTimetable addressTimetable = (AddressTimetable) o;
        return Objects.equals(thu, addressTimetable.thu) &&
                Objects.equals(tue, addressTimetable.tue) &&
                Objects.equals(sat, addressTimetable.sat) &&
                Objects.equals(wed, addressTimetable.wed) &&
                Objects.equals(fri, addressTimetable.fri) &&
                Objects.equals(mon, addressTimetable.mon) &&
                Objects.equals(sun, addressTimetable.sun);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddressTimetable{");
        sb.append("thu=").append(thu);
        sb.append(", tue=").append(tue);
        sb.append(", sat=").append(sat);
        sb.append(", wed=").append(wed);
        sb.append(", fri=").append(fri);
        sb.append(", mon=").append(mon);
        sb.append(", sun=").append(sun);
        sb.append('}');
        return sb.toString();
    }
}
