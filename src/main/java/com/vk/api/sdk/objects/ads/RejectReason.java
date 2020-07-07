package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.List;
import java.util.Objects;

/**
 * RejectReason object
 */
public class RejectReason implements Validable {
    /**
     * Comment text
     */
    @SerializedName("comment")
    private String comment;

    @SerializedName("rules")
    private List<Rules> rules;

    public String getComment() {
        return comment;
    }

    public RejectReason setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public RejectReason setRules(List<Rules> rules) {
        this.rules = rules;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, rules);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RejectReason rejectReason = (RejectReason) o;
        return Objects.equals(comment, rejectReason.comment) &&
                Objects.equals(rules, rejectReason.rules);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("RejectReason{");
        sb.append("comment='").append(comment).append("'");
        sb.append(", rules=").append(rules);
        sb.append('}');
        return sb.toString();
    }
}
