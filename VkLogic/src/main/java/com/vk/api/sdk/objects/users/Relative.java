package com.vk.api.sdk.objects.users;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Relative object
 */
public class Relative implements Validable {
    /**
     * Date of child birthday (format dd.mm.yyyy)
     */
    @SerializedName("birth_date")
    private String birthDate;

    /**
     * Relative ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Name of relative
     */
    @SerializedName("name")
    private String name;

    /**
     * Relative type
     */
    @SerializedName("type")
    @Required
    private RelativeType type;

    public String getBirthDate() {
        return birthDate;
    }

    public Relative setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Relative setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Relative setName(String name) {
        this.name = name;
        return this;
    }

    public RelativeType getType() {
        return type;
    }

    public Relative setType(RelativeType type) {
        this.type = type;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relative relative = (Relative) o;
        return Objects.equals(birthDate, relative.birthDate) &&
                Objects.equals(name, relative.name) &&
                Objects.equals(id, relative.id) &&
                Objects.equals(type, relative.type);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Relative{");
        sb.append("birthDate='").append(birthDate).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", type='").append(type).append("'");
        sb.append('}');
        return sb.toString();
    }
}
