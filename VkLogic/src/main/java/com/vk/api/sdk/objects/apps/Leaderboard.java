package com.vk.api.sdk.objects.apps;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Leaderboard object
 */
public class Leaderboard implements Validable {
    /**
     * Level
     */
    @SerializedName("level")
    private Integer level;

    /**
     * Points number
     */
    @SerializedName("points")
    private Integer points;

    /**
     * Score number
     */
    @SerializedName("score")
    private Integer score;

    /**
     * User ID
     */
    @SerializedName("user_id")
    private Integer userId;

    public Integer getLevel() {
        return level;
    }

    public Leaderboard setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public Leaderboard setPoints(Integer points) {
        this.points = points;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Leaderboard setScore(Integer score) {
        this.score = score;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Leaderboard setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, level, userId, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaderboard leaderboard = (Leaderboard) o;
        return Objects.equals(score, leaderboard.score) &&
                Objects.equals(level, leaderboard.level) &&
                Objects.equals(userId, leaderboard.userId) &&
                Objects.equals(points, leaderboard.points);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Leaderboard{");
        sb.append("score=").append(score);
        sb.append(", level=").append(level);
        sb.append(", userId=").append(userId);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
