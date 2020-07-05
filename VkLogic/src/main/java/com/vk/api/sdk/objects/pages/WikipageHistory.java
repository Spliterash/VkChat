package com.vk.api.sdk.objects.pages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * WikipageHistory object
 */
public class WikipageHistory implements Validable {
    /**
     * Version ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Page size in bytes
     */
    @SerializedName("length")
    @Required
    private Integer length;

    /**
     * Date when the page has been edited in Unixtime
     */
    @SerializedName("date")
    @Required
    private Integer date;

    /**
     * Last editor ID
     */
    @SerializedName("editor_id")
    private Integer editorId;

    /**
     * Last editor name
     */
    @SerializedName("editor_name")
    private String editorName;

    public Integer getId() {
        return id;
    }

    public WikipageHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public WikipageHistory setLength(Integer length) {
        this.length = length;
        return this;
    }

    public Integer getDate() {
        return date;
    }

    public WikipageHistory setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public WikipageHistory setEditorId(Integer editorId) {
        this.editorId = editorId;
        return this;
    }

    public String getEditorName() {
        return editorName;
    }

    public WikipageHistory setEditorName(String editorName) {
        this.editorName = editorName;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, editorName, editorId, length, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikipageHistory wikipageHistory = (WikipageHistory) o;
        return Objects.equals(date, wikipageHistory.date) &&
                Objects.equals(editorName, wikipageHistory.editorName) &&
                Objects.equals(length, wikipageHistory.length) &&
                Objects.equals(editorId, wikipageHistory.editorId) &&
                Objects.equals(id, wikipageHistory.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("WikipageHistory{");
        sb.append("date=").append(date);
        sb.append(", editorName='").append(editorName).append("'");
        sb.append(", length=").append(length);
        sb.append(", editorId=").append(editorId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
