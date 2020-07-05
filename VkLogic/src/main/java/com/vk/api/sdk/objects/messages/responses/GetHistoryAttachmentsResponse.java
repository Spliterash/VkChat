package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.messages.HistoryAttachment;
import java.util.List;
import java.util.Objects;

/**
 * GetHistoryAttachmentsResponse object
 */
public class GetHistoryAttachmentsResponse implements Validable {
    @SerializedName("items")
    private List<HistoryAttachment> items;

    /**
     * Value for pagination
     */
    @SerializedName("next_from")
    private String nextFrom;

    public List<HistoryAttachment> getItems() {
        return items;
    }

    public GetHistoryAttachmentsResponse setItems(List<HistoryAttachment> items) {
        this.items = items;
        return this;
    }

    public String getNextFrom() {
        return nextFrom;
    }

    public GetHistoryAttachmentsResponse setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextFrom, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetHistoryAttachmentsResponse getHistoryAttachmentsResponse = (GetHistoryAttachmentsResponse) o;
        return Objects.equals(nextFrom, getHistoryAttachmentsResponse.nextFrom) &&
                Objects.equals(items, getHistoryAttachmentsResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetHistoryAttachmentsResponse{");
        sb.append("nextFrom='").append(nextFrom).append("'");
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
