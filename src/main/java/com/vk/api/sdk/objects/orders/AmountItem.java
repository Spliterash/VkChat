package com.vk.api.sdk.objects.orders;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AmountItem object
 */
public class AmountItem implements Validable {
    /**
     * Votes amount in user's currency
     */
    @SerializedName("amount")
    private Integer amount;

    /**
     * Amount description
     */
    @SerializedName("description")
    private String description;

    /**
     * Votes number
     */
    @SerializedName("votes")
    private String votes;

    public Integer getAmount() {
        return amount;
    }

    public AmountItem setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AmountItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVotes() {
        return votes;
    }

    public AmountItem setVotes(String votes) {
        this.votes = votes;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, description, votes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountItem amountItem = (AmountItem) o;
        return Objects.equals(amount, amountItem.amount) &&
                Objects.equals(description, amountItem.description) &&
                Objects.equals(votes, amountItem.votes);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AmountItem{");
        sb.append("amount=").append(amount);
        sb.append(", description='").append(description).append("'");
        sb.append(", votes='").append(votes).append("'");
        sb.append('}');
        return sb.toString();
    }
}
