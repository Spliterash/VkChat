package com.vk.api.sdk.objects.users;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Exports object
 */
public class Exports implements Validable {
    @SerializedName("facebook")
    private Integer facebook;

    @SerializedName("livejournal")
    private Integer livejournal;

    @SerializedName("twitter")
    private Integer twitter;

    public Integer getFacebook() {
        return facebook;
    }

    public Exports setFacebook(Integer facebook) {
        this.facebook = facebook;
        return this;
    }

    public Integer getLivejournal() {
        return livejournal;
    }

    public Exports setLivejournal(Integer livejournal) {
        this.livejournal = livejournal;
        return this;
    }

    public Integer getTwitter() {
        return twitter;
    }

    public Exports setTwitter(Integer twitter) {
        this.twitter = twitter;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(twitter, facebook, livejournal);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exports exports = (Exports) o;
        return Objects.equals(twitter, exports.twitter) &&
                Objects.equals(facebook, exports.facebook) &&
                Objects.equals(livejournal, exports.livejournal);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Exports{");
        sb.append("twitter=").append(twitter);
        sb.append(", facebook=").append(facebook);
        sb.append(", livejournal=").append(livejournal);
        sb.append('}');
        return sb.toString();
    }
}
