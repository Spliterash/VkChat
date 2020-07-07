package com.vk.api.sdk.objects.secure;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Level object
 */
public class Level implements Validable {
    /**
     * Level
     */
    @SerializedName("level")
    private Integer level;

    /**
     * User ID
     */
    @SerializedName("uid")
    private Integer uid;

    public Integer getLevel() {
        return level;
    }

    public Level setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getUid() {
        return uid;
    }

    public Level setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return Objects.equals(uid, level.uid) &&
                Objects.equals(level, level.level);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Level{");
        sb.append("uid=").append(uid);
        sb.append(", level=").append(level);
        sb.append('}');
        return sb.toString();
    }
}
