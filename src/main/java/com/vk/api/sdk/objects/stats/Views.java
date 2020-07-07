package com.vk.api.sdk.objects.stats;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * Views stats
 */
public class Views implements Validable {
    @SerializedName("age")
    private List<SexAge> age;

    @SerializedName("cities")
    private List<City> cities;

    @SerializedName("countries")
    private List<Country> countries;

    /**
     * Number of views from mobile devices
     */
    @SerializedName("mobile_views")
    private Integer mobileViews;

    @SerializedName("sex")
    private List<SexAge> sex;

    @SerializedName("sex_age")
    private List<SexAge> sexAge;

    /**
     * Views number
     */
    @SerializedName("views")
    private Integer views;

    /**
     * Visitors number
     */
    @SerializedName("visitors")
    private Integer visitors;

    public List<SexAge> getAge() {
        return age;
    }

    public Views setAge(List<SexAge> age) {
        this.age = age;
        return this;
    }

    public List<City> getCities() {
        return cities;
    }

    public Views setCities(List<City> cities) {
        this.cities = cities;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Views setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }

    public Integer getMobileViews() {
        return mobileViews;
    }

    public Views setMobileViews(Integer mobileViews) {
        this.mobileViews = mobileViews;
        return this;
    }

    public List<SexAge> getSex() {
        return sex;
    }

    public Views setSex(List<SexAge> sex) {
        this.sex = sex;
        return this;
    }

    public List<SexAge> getSexAge() {
        return sexAge;
    }

    public Views setSexAge(List<SexAge> sexAge) {
        this.sexAge = sexAge;
        return this;
    }

    public Integer getViews() {
        return views;
    }

    public Views setViews(Integer views) {
        this.views = views;
        return this;
    }

    public Integer getVisitors() {
        return visitors;
    }

    public Views setVisitors(Integer visitors) {
        this.visitors = visitors;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitors, mobileViews, cities, sex, countries, sexAge, age, views);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Views views = (Views) o;
        return Objects.equals(visitors, views.visitors) &&
                Objects.equals(cities, views.cities) &&
                Objects.equals(sex, views.sex) &&
                Objects.equals(countries, views.countries) &&
                Objects.equals(sexAge, views.sexAge) &&
                Objects.equals(mobileViews, views.mobileViews) &&
                Objects.equals(age, views.age) &&
                Objects.equals(views, views.views);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Views{");
        sb.append("visitors=").append(visitors);
        sb.append(", cities=").append(cities);
        sb.append(", sex=").append(sex);
        sb.append(", countries=").append(countries);
        sb.append(", sexAge=").append(sexAge);
        sb.append(", mobileViews=").append(mobileViews);
        sb.append(", age=").append(age);
        sb.append(", views=").append(views);
        sb.append('}');
        return sb.toString();
    }
}
