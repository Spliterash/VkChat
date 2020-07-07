package com.vk.api.sdk.objects.stories;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Replies object
 */
public class Replies implements Validable {
    /**
     * Replies number.
     */
    @SerializedName("count")
    @Required
    private Integer count;

    /**
     * New replies number.
     */
    @SerializedName("new")
    private Integer _new;

    public Integer getCount() {
        return count;
    }

    public Replies setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer get_new() {
        return _new;
    }

    public Replies set_new(Integer _new) {
        this._new = _new;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, _new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replies replies = (Replies) o;
        return Objects.equals(_new, replies._new) &&
                Objects.equals(count, replies.count);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Replies{");
        sb.append("_new=").append(_new);
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
