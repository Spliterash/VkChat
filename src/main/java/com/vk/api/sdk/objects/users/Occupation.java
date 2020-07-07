package com.vk.api.sdk.objects.users;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Occupation object
 */
public class Occupation implements Validable {
    /**
     * ID of school, university, company group
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Name of occupation
     */
    @SerializedName("name")
    private String name;

    /**
     * Type of occupation
     */
    @SerializedName("type")
    private String type;

    public Integer getId() {
        return id;
    }

    public Occupation setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Occupation setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Occupation setType(String type) {
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
        Occupation occupation = (Occupation) o;
        return Objects.equals(name, occupation.name) &&
                Objects.equals(id, occupation.id) &&
                Objects.equals(type, occupation.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Occupation{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", type='").append(type).append("'");
        sb.append('}');
        return sb.toString();
    }
}
