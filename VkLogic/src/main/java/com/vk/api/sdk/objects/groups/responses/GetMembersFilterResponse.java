package com.vk.api.sdk.objects.groups.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import com.vk.api.sdk.objects.groups.MemberRole;
import java.util.List;
import java.util.Objects;

/**
 * GetMembersFilterResponse object
 */
public class GetMembersFilterResponse implements Validable {
    /**
     * Total members number
     */
    @SerializedName("count")
    @Required
    private Integer count;

    @SerializedName("items")
    @Required
    private List<MemberRole> items;

    public Integer getCount() {
        return count;
    }

    public GetMembersFilterResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<MemberRole> getItems() {
        return items;
    }

    public GetMembersFilterResponse setItems(List<MemberRole> items) {
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
        GetMembersFilterResponse getMembersFilterResponse = (GetMembersFilterResponse) o;
        return Objects.equals(count, getMembersFilterResponse.count) &&
                Objects.equals(items, getMembersFilterResponse.items);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetMembersFilterResponse{");
        sb.append("count=").append(count);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
