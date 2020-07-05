package com.vk.api.sdk.objects.notifications;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Reply object
 */
public class Reply implements Validable {
    /**
     * Date when the reply has been created in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Reply ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Reply text
     */
    @SerializedName("text")
    private Integer text;

    public Integer getDate() {
        return date;
    }

    public Reply setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Reply setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getText() {
        return text;
    }

    public Reply setText(Integer text) {
        this.text = text;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, id, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return Objects.equals(date, reply.date) &&
                Objects.equals(id, reply.id) &&
                Objects.equals(text, reply.text);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Reply{");
        sb.append("date=").append(date);
        sb.append(", id=").append(id);
        sb.append(", text=").append(text);
        sb.append('}');
        return sb.toString();
    }
}
