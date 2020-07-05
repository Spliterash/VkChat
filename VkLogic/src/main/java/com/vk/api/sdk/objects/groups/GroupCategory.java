package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.base.ObjectWithName;
import java.util.List;
import java.util.Objects;

/**
 * GroupCategory object
 */
public class GroupCategory implements Validable {
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

    @SerializedName("subcategories")
    private List<ObjectWithName> subcategories;

    public Integer getId() {
        return id;
    }

    public GroupCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GroupCategory setName(String name) {
        this.name = name;
        return this;
    }

    public List<ObjectWithName> getSubcategories() {
        return subcategories;
    }

    public GroupCategory setSubcategories(List<ObjectWithName> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, subcategories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupCategory groupCategory = (GroupCategory) o;
        return Objects.equals(name, groupCategory.name) &&
                Objects.equals(id, groupCategory.id) &&
                Objects.equals(subcategories, groupCategory.subcategories);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GroupCategory{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", subcategories=").append(subcategories);
        sb.append('}');
        return sb.toString();
    }
}
