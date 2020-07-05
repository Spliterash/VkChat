package com.vk.api.sdk.objects.friends.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * AddListResponse object
 */
public class AddListResponse implements Validable {
    /**
     * List ID
     */
    @SerializedName("list_id")
    private Integer listId;

    public Integer getListId() {
        return listId;
    }

    public AddListResponse setListId(Integer listId) {
        this.listId = listId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddListResponse addListResponse = (AddListResponse) o;
        return Objects.equals(listId, addListResponse.listId);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("AddListResponse{");
        sb.append("listId=").append(listId);
        sb.append('}');
        return sb.toString();
    }
}
