package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Period object
 */
public class Period implements Validable {
    @SerializedName("activity")
    private Activity activity;

    /**
     * Unix timestamp
     */
    @SerializedName("period_from")
    private Integer periodFrom;

    /**
     * Unix timestamp
     */
    @SerializedName("period_to")
    private Integer periodTo;

    @SerializedName("reach")
    private Reach reach;

    @SerializedName("visitors")
    private Views visitors;

    public Activity getActivity() {
        return activity;
    }

    public Period setActivity(Activity activity) {
        this.activity = activity;
        return this;
    }

    public Integer getPeriodFrom() {
        return periodFrom;
    }

    public Period setPeriodFrom(Integer periodFrom) {
        this.periodFrom = periodFrom;
        return this;
    }

    public Integer getPeriodTo() {
        return periodTo;
    }

    public Period setPeriodTo(Integer periodTo) {
        this.periodTo = periodTo;
        return this;
    }

    public Reach getReach() {
        return reach;
    }

    public Period setReach(Reach reach) {
        this.reach = reach;
        return this;
    }

    public Views getVisitors() {
        return visitors;
    }

    public Period setVisitors(Views visitors) {
        this.visitors = visitors;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitors, periodTo, activity, reach, periodFrom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(visitors, period.visitors) &&
                Objects.equals(activity, period.activity) &&
                Objects.equals(reach, period.reach) &&
                Objects.equals(periodFrom, period.periodFrom) &&
                Objects.equals(periodTo, period.periodTo);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Period{");
        sb.append("visitors=").append(visitors);
        sb.append(", activity=").append(activity);
        sb.append(", reach=").append(reach);
        sb.append(", periodFrom=").append(periodFrom);
        sb.append(", periodTo=").append(periodTo);
        sb.append('}');
        return sb.toString();
    }
}
