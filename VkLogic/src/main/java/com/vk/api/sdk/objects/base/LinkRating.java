package com.vk.api.sdk.objects.base;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * LinkRating object
 */
public class LinkRating implements Validable {
    /**
     * Count of reviews
     */
    @SerializedName("reviews_count")
    private Integer reviewsCount;

    /**
     * Count of stars
     */
    @SerializedName("stars")
    private Float stars;

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public LinkRating setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
        return this;
    }

    public Float getStars() {
        return stars;
    }

    public LinkRating setStars(Float stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars, reviewsCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkRating linkRating = (LinkRating) o;
        return Objects.equals(stars, linkRating.stars) &&
                Objects.equals(reviewsCount, linkRating.reviewsCount);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LinkRating{");
        sb.append("stars=").append(stars);
        sb.append(", reviewsCount=").append(reviewsCount);
        sb.append('}');
        return sb.toString();
    }
}
