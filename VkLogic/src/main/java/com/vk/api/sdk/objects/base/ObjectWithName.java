package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * ObjectWithName object
 */
public class ObjectWithName implements Validable {
    /**
     * Object ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Object name
     */
    @SerializedName("name")
    @Required
    private String name;

    public Integer getId() {
        return id;
    }

    public ObjectWithName setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ObjectWithName setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectWithName objectWithName = (ObjectWithName) o;
        return Objects.equals(name, objectWithName.name) &&
                Objects.equals(id, objectWithName.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("ObjectWithName{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
