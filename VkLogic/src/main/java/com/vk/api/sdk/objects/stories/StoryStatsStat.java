package com.vk.api.sdk.objects.stories;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * StoryStatsStat object
 */
public class StoryStatsStat implements Validable {
    /**
     * Stat value
     */
    @SerializedName("count")
    private Integer count;

    @SerializedName("state")
    @Required
    private StoryStatsState state;

    public Integer getCount() {
        return count;
    }

    public StoryStatsStat setCount(Integer count) {
        this.count = count;
        return this;
    }

    public StoryStatsState getState() {
        return state;
    }

    public StoryStatsStat setState(StoryStatsState state) {
        this.state = state;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoryStatsStat storyStatsStat = (StoryStatsStat) o;
        return Objects.equals(count, storyStatsStat.count) &&
                Objects.equals(state, storyStatsStat.state);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StoryStatsStat{");
        sb.append("count=").append(count);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
