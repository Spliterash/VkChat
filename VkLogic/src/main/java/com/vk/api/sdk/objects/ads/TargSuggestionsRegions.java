package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * TargSuggestionsRegions object
 */
public class TargSuggestionsRegions implements Validable {
    /**
     * Object ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Object name
     */
    @SerializedName("name")
    private String name;

    /**
     * Object type
     */
    @SerializedName("type")
    private String type;

    public Integer getId() {
        return id;
    }

    public TargSuggestionsRegions setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TargSuggestionsRegions setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public TargSuggestionsRegions setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargSuggestionsRegions targSuggestionsRegions = (TargSuggestionsRegions) o;
        return Objects.equals(name, targSuggestionsRegions.name) &&
                Objects.equals(id, targSuggestionsRegions.id) &&
                Objects.equals(type, targSuggestionsRegions.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("TargSuggestionsRegions{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", type='").append(type).append("'");
        sb.append('}');
        return sb.toString();
    }
}
