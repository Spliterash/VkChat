package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.List;
import java.util.Objects;

/**
 * GroupCategoryFull object
 */
public class GroupCategoryFull implements Validable {
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

    /**
     * Pages number
     */
    @SerializedName("page_count")
    private Integer pageCount;

    @SerializedName("page_previews")
    private List<Group> pagePreviews;

    @SerializedName("subcategories")
    private List<GroupCategory> subcategories;

    public Integer getId() {
        return id;
    }

    public GroupCategoryFull setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GroupCategoryFull setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public GroupCategoryFull setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public List<Group> getPagePreviews() {
        return pagePreviews;
    }

    public GroupCategoryFull setPagePreviews(List<Group> pagePreviews) {
        this.pagePreviews = pagePreviews;
        return this;
    }

    public List<GroupCategory> getSubcategories() {
        return subcategories;
    }

    public GroupCategoryFull setSubcategories(List<GroupCategory> subcategories) {
        this.subcategories = subcategories;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagePreviews, pageCount, name, id, subcategories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupCategoryFull groupCategoryFull = (GroupCategoryFull) o;
        return Objects.equals(pagePreviews, groupCategoryFull.pagePreviews) &&
                Objects.equals(name, groupCategoryFull.name) &&
                Objects.equals(id, groupCategoryFull.id) &&
                Objects.equals(subcategories, groupCategoryFull.subcategories) &&
                Objects.equals(pageCount, groupCategoryFull.pageCount);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GroupCategoryFull{");
        sb.append("pagePreviews=").append(pagePreviews);
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", subcategories=").append(subcategories);
        sb.append(", pageCount=").append(pageCount);
        sb.append('}');
        return sb.toString();
    }
}
