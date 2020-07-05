package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * PollVoteNew object
 */
public class PollVoteNew implements Validable {
    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("poll_id")
    private Integer pollId;

    @SerializedName("option_id")
    private Integer optionId;

    @SerializedName("user_id")
    private Integer userId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public PollVoteNew setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getPollId() {
        return pollId;
    }

    public PollVoteNew setPollId(Integer pollId) {
        this.pollId = pollId;
        return this;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public PollVoteNew setOptionId(Integer optionId) {
        this.optionId = optionId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public PollVoteNew setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollId, optionId, ownerId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollVoteNew pollVoteNew = (PollVoteNew) o;
        return Objects.equals(pollId, pollVoteNew.pollId) &&
                Objects.equals(userId, pollVoteNew.userId) &&
                Objects.equals(ownerId, pollVoteNew.ownerId) &&
                Objects.equals(optionId, pollVoteNew.optionId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("PollVoteNew{");
        sb.append("pollId=").append(pollId);
        sb.append(", userId=").append(userId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", optionId=").append(optionId);
        sb.append('}');
        return sb.toString();
    }
}
