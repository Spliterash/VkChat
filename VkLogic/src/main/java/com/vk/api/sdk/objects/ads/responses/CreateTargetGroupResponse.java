package com.vk.api.sdk.objects.ads.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * CreateTargetGroupResponse object
 */
public class CreateTargetGroupResponse implements Validable {
    /**
     * Group ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Pixel code
     */
    @SerializedName("pixel")
    private String pixel;

    public Integer getId() {
        return id;
    }

    public CreateTargetGroupResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPixel() {
        return pixel;
    }

    public CreateTargetGroupResponse setPixel(String pixel) {
        this.pixel = pixel;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pixel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTargetGroupResponse createTargetGroupResponse = (CreateTargetGroupResponse) o;
        return Objects.equals(id, createTargetGroupResponse.id) &&
                Objects.equals(pixel, createTargetGroupResponse.pixel);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CreateTargetGroupResponse{");
        sb.append("id=").append(id);
        sb.append(", pixel='").append(pixel).append("'");
        sb.append('}');
        return sb.toString();
    }
}
