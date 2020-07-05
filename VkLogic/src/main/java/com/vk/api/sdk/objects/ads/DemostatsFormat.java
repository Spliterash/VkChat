package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * DemostatsFormat object
 */
public class DemostatsFormat implements Validable {
    @SerializedName("age")
    private List<StatsAge> age;

    @SerializedName("cities")
    private List<StatsCities> cities;

    /**
     * Day as YYYY-MM-DD
     */
    @SerializedName("day")
    private String day;

    /**
     * Month as YYYY-MM
     */
    @SerializedName("month")
    private String month;

    /**
     * 1 if period=overall
     */
    @SerializedName("overall")
    private Integer overall;

    @SerializedName("sex")
    private List<StatsSex> sex;

    @SerializedName("sex_age")
    private List<StatsSexAge> sexAge;

    public List<StatsAge> getAge() {
        return age;
    }

    public DemostatsFormat setAge(List<StatsAge> age) {
        this.age = age;
        return this;
    }

    public List<StatsCities> getCities() {
        return cities;
    }

    public DemostatsFormat setCities(List<StatsCities> cities) {
        this.cities = cities;
        return this;
    }

    public String getDay() {
        return day;
    }

    public DemostatsFormat setDay(String day) {
        this.day = day;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public DemostatsFormat setMonth(String month) {
        this.month = month;
        return this;
    }

    public Integer getOverall() {
        return overall;
    }

    public DemostatsFormat setOverall(Integer overall) {
        this.overall = overall;
        return this;
    }

    public List<StatsSex> getSex() {
        return sex;
    }

    public DemostatsFormat setSex(List<StatsSex> sex) {
        this.sex = sex;
        return this;
    }

    public List<StatsSexAge> getSexAge() {
        return sexAge;
    }

    public DemostatsFormat setSexAge(List<StatsSexAge> sexAge) {
        this.sexAge = sexAge;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities, month, sex, overall, sexAge, day, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemostatsFormat demostatsFormat = (DemostatsFormat) o;
        return Objects.equals(cities, demostatsFormat.cities) &&
                Objects.equals(month, demostatsFormat.month) &&
                Objects.equals(sex, demostatsFormat.sex) &&
                Objects.equals(overall, demostatsFormat.overall) &&
                Objects.equals(sexAge, demostatsFormat.sexAge) &&
                Objects.equals(day, demostatsFormat.day) &&
                Objects.equals(age, demostatsFormat.age);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DemostatsFormat{");
        sb.append("cities=").append(cities);
        sb.append(", month='").append(month).append("'");
        sb.append(", sex=").append(sex);
        sb.append(", overall=").append(overall);
        sb.append(", sexAge=").append(sexAge);
        sb.append(", day='").append(day).append("'");
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
