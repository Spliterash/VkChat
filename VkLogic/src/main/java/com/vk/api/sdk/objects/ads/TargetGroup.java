package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * TargetGroup object
 */
public class TargetGroup implements Validable {
    /**
     * Audience
     */
    @SerializedName("audience_count")
    private Integer audienceCount;

    /**
     * Site domain
     */
    @SerializedName("domain")
    private String domain;

    /**
     * Group ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Number of days for user to be in group
     */
    @SerializedName("lifetime")
    private Integer lifetime;

    /**
     * Group name
     */
    @SerializedName("name")
    private String name;

    /**
     * Pixel code
     */
    @SerializedName("pixel")
    private String pixel;

    public Integer getAudienceCount() {
        return audienceCount;
    }

    public TargetGroup setAudienceCount(Integer audienceCount) {
        this.audienceCount = audienceCount;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public TargetGroup setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public TargetGroup setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getLifetime() {
        return lifetime;
    }

    public TargetGroup setLifetime(Integer lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public String getName() {
        return name;
    }

    public TargetGroup setName(String name) {
        this.name = name;
        return this;
    }

    public String getPixel() {
        return pixel;
    }

    public TargetGroup setPixel(String pixel) {
        this.pixel = pixel;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, audienceCount, lifetime, name, id, pixel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetGroup targetGroup = (TargetGroup) o;
        return Objects.equals(domain, targetGroup.domain) &&
                Objects.equals(audienceCount, targetGroup.audienceCount) &&
                Objects.equals(lifetime, targetGroup.lifetime) &&
                Objects.equals(name, targetGroup.name) &&
                Objects.equals(id, targetGroup.id) &&
                Objects.equals(pixel, targetGroup.pixel);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("TargetGroup{");
        sb.append("domain='").append(domain).append("'");
        sb.append(", audienceCount=").append(audienceCount);
        sb.append(", lifetime=").append(lifetime);
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append(", pixel='").append(pixel).append("'");
        sb.append('}');
        return sb.toString();
    }
}
