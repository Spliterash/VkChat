package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * Rules object
 */
public class Rules implements Validable {
    @SerializedName("paragraphs")
    private List<Paragraphs> paragraphs;

    /**
     * Comment
     */
    @SerializedName("title")
    private String title;

    public List<Paragraphs> getParagraphs() {
        return paragraphs;
    }

    public Rules setParagraphs(List<Paragraphs> paragraphs) {
        this.paragraphs = paragraphs;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Rules setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphs, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rules rules = (Rules) o;
        return Objects.equals(paragraphs, rules.paragraphs) &&
                Objects.equals(title, rules.title);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Rules{");
        sb.append("paragraphs=").append(paragraphs);
        sb.append(", title='").append(title).append("'");
        sb.append('}');
        return sb.toString();
    }
}
