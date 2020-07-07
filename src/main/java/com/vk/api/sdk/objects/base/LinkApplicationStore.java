package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * LinkApplicationStore object
 */
public class LinkApplicationStore implements Validable {
    /**
     * Store Id
     */
    @SerializedName("id")
    private Float id;

    /**
     * Store name
     */
    @SerializedName("name")
    private String name;

    public Float getId() {
        return id;
    }

    public LinkApplicationStore setId(Float id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LinkApplicationStore setName(String name) {
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
        LinkApplicationStore linkApplicationStore = (LinkApplicationStore) o;
        return Objects.equals(name, linkApplicationStore.name) &&
                Objects.equals(id, linkApplicationStore.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LinkApplicationStore{");
        sb.append("name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
