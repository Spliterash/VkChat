package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * CallbackSettings object
 */
public class CallbackSettings implements Validable {
    /**
     * API version used for the events
     */
    @SerializedName("api_version")
    private String apiVersion;

    @SerializedName("events")
    private LongPollEvents events;

    public String getApiVersion() {
        return apiVersion;
    }

    public CallbackSettings setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public LongPollEvents getEvents() {
        return events;
    }

    public CallbackSettings setEvents(LongPollEvents events) {
        this.events = events;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiVersion, events);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallbackSettings callbackSettings = (CallbackSettings) o;
        return Objects.equals(apiVersion, callbackSettings.apiVersion) &&
                Objects.equals(events, callbackSettings.events);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CallbackSettings{");
        sb.append("apiVersion='").append(apiVersion).append("'");
        sb.append(", events=").append(events);
        sb.append('}');
        return sb.toString();
    }
}
