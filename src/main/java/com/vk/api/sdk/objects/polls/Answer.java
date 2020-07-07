package com.vk.api.sdk.objects.polls;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Answer object
 */
public class Answer implements Validable {
    /**
     * Answer ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Answer rate in percents
     */
    @SerializedName("rate")
    @Required
    private Float rate;

    /**
     * Answer text
     */
    @SerializedName("text")
    @Required
    private String text;

    /**
     * Votes number
     */
    @SerializedName("votes")
    @Required
    private Integer votes;

    public Integer getId() {
        return id;
    }

    public Answer setId(Integer id) {
        this.id = id;
        return this;
    }

    public Float getRate() {
        return rate;
    }

    public Answer setRate(Float rate) {
        this.rate = rate;
        return this;
    }

    public String getText() {
        return text;
    }

    public Answer setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getVotes() {
        return votes;
    }

    public Answer setVotes(Integer votes) {
        this.votes = votes;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, votes, id, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(rate, answer.rate) &&
                Objects.equals(votes, answer.votes) &&
                Objects.equals(id, answer.id) &&
                Objects.equals(text, answer.text);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Answer{");
        sb.append("rate=").append(rate);
        sb.append(", votes=").append(votes);
        sb.append(", id=").append(id);
        sb.append(", text='").append(text).append("'");
        sb.append('}');
        return sb.toString();
    }
}
