package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.messages.Conversation;
import java.util.List;
import java.util.Objects;

/**
 * GetConversationsByIdResponse object
 */
public class GetConversationsByIdResponse implements Validable {
    /**
     * Total number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<Conversation> items;

    public Integer getCount() {
        return count;
    }

    public GetConversationsByIdResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Conversation> getItems() {
        return items;
    }

    public GetConversationsByIdResponse setItems(List<Conversation> items) {
        this.items = items;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetConversationsByIdResponse getConversationsByIdResponse = (GetConversationsByIdResponse) o;
        return Objects.equals(count, getConversationsByIdResponse.count) &&
                Objects.equals(items, getConversationsByIdResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetConversationsByIdResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
