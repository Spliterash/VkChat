package com.vk.api.sdk.objects.ads;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Client object
 */
public class Client implements Validable {
    /**
     * Client's total limit, rubles
     */
    @SerializedName("all_limit")
    private String allLimit;

    /**
     * Client's day limit, rubles
     */
    @SerializedName("day_limit")
    private String dayLimit;

    /**
     * Client ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Client name
     */
    @SerializedName("name")
    @Required
    private String name;

    public String getAllLimit() {
        return allLimit;
    }

    public Client setAllLimit(String allLimit) {
        this.allLimit = allLimit;
        return this;
    }

    public String getDayLimit() {
        return dayLimit;
    }

    public Client setDayLimit(String dayLimit) {
        this.dayLimit = dayLimit;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Client setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayLimit, allLimit, name, id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(allLimit, client.allLimit) &&
                Objects.equals(dayLimit, client.dayLimit) &&
                Objects.equals(name, client.name) &&
                Objects.equals(id, client.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("allLimit='").append(allLimit).append("'");
        sb.append(", dayLimit='").append(dayLimit).append("'");
        sb.append(", name='").append(name).append("'");
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
