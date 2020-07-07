package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Timetable for one day
 */
public class AddressTimetableDay implements Validable {
    /**
     * Close time of the break in minutes
     */
    @SerializedName("break_close_time")
    private Integer breakCloseTime;

    /**
     * Start time of the break in minutes
     */
    @SerializedName("break_open_time")
    private Integer breakOpenTime;

    /**
     * Close time in minutes
     */
    @SerializedName("close_time")
    private Integer closeTime;

    /**
     * Open time in minutes
     */
    @SerializedName("open_time")
    private Integer openTime;

    public Integer getBreakCloseTime() {
        return breakCloseTime;
    }

    public AddressTimetableDay setBreakCloseTime(Integer breakCloseTime) {
        this.breakCloseTime = breakCloseTime;
        return this;
    }

    public Integer getBreakOpenTime() {
        return breakOpenTime;
    }

    public AddressTimetableDay setBreakOpenTime(Integer breakOpenTime) {
        this.breakOpenTime = breakOpenTime;
        return this;
    }

    public Integer getCloseTime() {
        return closeTime;
    }

    public AddressTimetableDay setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public Integer getOpenTime() {
        return openTime;
    }

    public AddressTimetableDay setOpenTime(Integer openTime) {
        this.openTime = openTime;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breakOpenTime, breakCloseTime, closeTime, openTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressTimetableDay addressTimetableDay = (AddressTimetableDay) o;
        return Objects.equals(breakOpenTime, addressTimetableDay.breakOpenTime) &&
                Objects.equals(openTime, addressTimetableDay.openTime) &&
                Objects.equals(breakCloseTime, addressTimetableDay.breakCloseTime) &&
                Objects.equals(closeTime, addressTimetableDay.closeTime);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddressTimetableDay{");
        sb.append("breakOpenTime=").append(breakOpenTime);
        sb.append(", openTime=").append(openTime);
        sb.append(", breakCloseTime=").append(breakCloseTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append('}');
        return sb.toString();
    }
}
