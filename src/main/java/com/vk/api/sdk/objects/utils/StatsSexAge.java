package com.vk.api.sdk.objects.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * StatsSexAge object
 */
public class StatsSexAge implements Validable {
    /**
     * Age denotation
     */
    @SerializedName("age_range")
    private String ageRange;

    /**
     *  Views by female users
     */
    @SerializedName("female")
    private Integer female;

    /**
     *  Views by male users
     */
    @SerializedName("male")
    private Integer male;

    public String getAgeRange() {
        return ageRange;
    }

    public StatsSexAge setAgeRange(String ageRange) {
        this.ageRange = ageRange;
        return this;
    }

    public Integer getFemale() {
        return female;
    }

    public StatsSexAge setFemale(Integer female) {
        this.female = female;
        return this;
    }

    public Integer getMale() {
        return male;
    }

    public StatsSexAge setMale(Integer male) {
        this.male = male;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageRange, female, male);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatsSexAge statsSexAge = (StatsSexAge) o;
        return Objects.equals(ageRange, statsSexAge.ageRange) &&
                Objects.equals(female, statsSexAge.female) &&
                Objects.equals(male, statsSexAge.male);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("StatsSexAge{");
        sb.append("ageRange='").append(ageRange).append("'");
        sb.append(", female=").append(female);
        sb.append(", male=").append(male);
        sb.append('}');
        return sb.toString();
    }
}
