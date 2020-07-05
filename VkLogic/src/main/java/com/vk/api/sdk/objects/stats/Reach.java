package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * Reach stats
 */
public class Reach implements Validable {
    @SerializedName("age")
    private List<SexAge> age;

    @SerializedName("cities")
    private List<City> cities;

    @SerializedName("countries")
    private List<Country> countries;

    /**
     * Reach count from mobile devices
     */
    @SerializedName("mobile_reach")
    private Integer mobileReach;

    /**
     * Reach count
     */
    @SerializedName("reach")
    private Integer reach;

    /**
     * Subscribers reach count
     */
    @SerializedName("reach_subscribers")
    private Integer reachSubscribers;

    @SerializedName("sex")
    private List<SexAge> sex;

    @SerializedName("sex_age")
    private List<SexAge> sexAge;

    public List<SexAge> getAge() {
        return age;
    }

    public Reach setAge(List<SexAge> age) {
        this.age = age;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public Reach setCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Reach setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }

    public Integer getMobileReach() {
        return mobileReach;
    }

    public Reach setMobileReach(Integer mobileReach) {
        this.mobileReach = mobileReach;
        return this;
    }

    public Integer getReach() {
        return reach;
    }

    public Reach setReach(Integer reach) {
        this.reach = reach;
        return this;
    }

    public Integer getReachSubscribers() {
        return reachSubscribers;
    }

    public Reach setReachSubscribers(Integer reachSubscribers) {
        this.reachSubscribers = reachSubscribers;
        return this;
    }

    public List<SexAge> getSex() {
        return sex;
    }

    public Reach setSex(List<SexAge> sex) {
        this.sex = sex;
        return this;
    }

    public List<SexAge> getSexAge() {
        return sexAge;
    }

    public Reach setSexAge(List<SexAge> sexAge) {
        this.sexAge = sexAge;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileReach, cities, reachSubscribers, reach, sex, countries, sexAge, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reach reach = (Reach) o;
        return Objects.equals(reachSubscribers, reach.reachSubscribers) &&
                Objects.equals(cities, reach.cities) &&
                Objects.equals(mobileReach, reach.mobileReach) &&
                Objects.equals(reach, reach.reach) &&
                Objects.equals(sex, reach.sex) &&
                Objects.equals(countries, reach.countries) &&
                Objects.equals(sexAge, reach.sexAge) &&
                Objects.equals(age, reach.age);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Reach{");
        sb.append("reachSubscribers=").append(reachSubscribers);
        sb.append(", cities=").append(cities);
        sb.append(", mobileReach=").append(mobileReach);
        sb.append(", reach=").append(reach);
        sb.append(", sex=").append(sex);
        sb.append(", countries=").append(countries);
        sb.append(", sexAge=").append(sexAge);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
