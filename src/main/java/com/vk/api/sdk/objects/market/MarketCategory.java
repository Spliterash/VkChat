package com.vk.api.sdk.objects.market;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * MarketCategory object
 */
public class MarketCategory implements Validable {
    /**
     * Category ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Category name
     */
    @SerializedName("name")
    @Required
    private String name;

    @SerializedName("section")
    @Required
    private Section section;

    public Integer getId() {
        return id;
    }

    public MarketCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MarketCategory setName(String name) {
        this.name = name;
        return this;
    }

    public Section getSection() {
        return section;
    }

    public MarketCategory setSection(Section section) {
        this.section = section;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, section, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketCategory marketCategory = (MarketCategory) o;
        return Objects.equals(name, marketCategory.name) &&
                Objects.equals(section, marketCategory.section) &&
                Objects.equals(id, marketCategory.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MarketCategory{");
        sb.append("name='").append(name).append("'");
        sb.append(", section=").append(section);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
