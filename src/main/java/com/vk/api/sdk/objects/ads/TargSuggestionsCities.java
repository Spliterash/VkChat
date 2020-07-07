package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * TargSuggestionsCities object
 */
public class TargSuggestionsCities implements Validable {
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
     * Parent object
     */
    @SerializedName("parent")
    private String parent;

    public Integer getId() {
        return id;
    }

    public TargSuggestionsCities setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TargSuggestionsCities setName(String name) {
        this.name = name;
        return this;
    }

    public String getParent() {
        return parent;
    }

    public TargSuggestionsCities setParent(String parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargSuggestionsCities targSuggestionsCities = (TargSuggestionsCities) o;
        return Objects.equals(parent, targSuggestionsCities.parent) &&
                Objects.equals(name, targSuggestionsCities.name) &&
                Objects.equals(id, targSuggestionsCities.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("TargSuggestionsCities{");
        sb.append("parent='").append(parent).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
