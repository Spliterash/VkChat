package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * LongpollParams object
 */
public class LongpollParams implements Validable {
    /**
     * Key
     */
    @SerializedName("key")
    private String key;

    /**
     * Persistent timestamp
     */
    @SerializedName("pts")
    private Integer pts;

    /**
     * Server URL
     */
    @SerializedName("server")
    private String server;

    /**
     * Timestamp
     */
    @SerializedName("ts")
    private Integer ts;

    public String getKey() {
        return key;
    }

    public LongpollParams setKey(String key) {
        this.key = key;
        return this;
    }

    public Integer getPts() {
        return pts;
    }

    public LongpollParams setPts(Integer pts) {
        this.pts = pts;
        return this;
    }

    public String getServer() {
        return server;
    }

    public LongpollParams setServer(String server) {
        this.server = server;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public LongpollParams setTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, key, pts, ts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongpollParams longpollParams = (LongpollParams) o;
        return Objects.equals(server, longpollParams.server) &&
                Objects.equals(key, longpollParams.key) &&
                Objects.equals(pts, longpollParams.pts) &&
                Objects.equals(ts, longpollParams.ts);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("LongpollParams{");
        sb.append("server='").append(server).append("'");
        sb.append(", key='").append(key).append("'");
        sb.append(", pts=").append(pts);
        sb.append(", ts=").append(ts);
        sb.append('}');
        return sb.toString();
    }
}
