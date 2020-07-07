package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * TargSuggestionsSchools object
 */
public class TargSuggestionsSchools implements Validable {
    /**
     * Full school title
     */
    @SerializedName("desc")
    private String desc;

    /**
     * School ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * School title
     */
    @SerializedName("name")
    private String name;

    /**
     * City name
     */
    @SerializedName("parent")
    private String parent;

    @SerializedName("type")
    private TargSuggestionsSchoolsType type;

    public String getDesc() {
        return desc;
    }

    public TargSuggestionsSchools setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public TargSuggestionsSchools setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TargSuggestionsSchools setName(String name) {
        this.name = name;
        return this;
    }

    public String getParent() {
        return parent;
    }

    public TargSuggestionsSchools setParent(String parent) {
        this.parent = parent;
        return this;
    }

    public TargSuggestionsSchoolsType getType() {
        return type;
    }

    public TargSuggestionsSchools setType(TargSuggestionsSchoolsType type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name, id, type, desc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargSuggestionsSchools targSuggestionsSchools = (TargSuggestionsSchools) o;
        return Objects.equals(parent, targSuggestionsSchools.parent) &&
                Objects.equals(name, targSuggestionsSchools.name) &&
                Objects.equals(id, targSuggestionsSchools.id) &&
                Objects.equals(type, targSuggestionsSchools.type) &&
                Objects.equals(desc, targSuggestionsSchools.desc);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("TargSuggestionsSchools{");
        sb.append("parent='").append(parent).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", desc='").append(desc).append("'");
        sb.append('}');
        return sb.toString();
    }
}
