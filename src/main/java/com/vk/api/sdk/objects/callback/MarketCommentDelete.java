package com.vk.api.sdk.objects.callback;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * MarketCommentDelete object
 */
public class MarketCommentDelete implements Validable {
    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("item_id")
    private Integer itemId;

    public Integer getOwnerId() {
        return ownerId;
    }

    public MarketCommentDelete setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public MarketCommentDelete setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public MarketCommentDelete setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getItemId() {
        return itemId;
    }

    public MarketCommentDelete setItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, id, ownerId, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketCommentDelete marketCommentDelete = (MarketCommentDelete) o;
        return Objects.equals(userId, marketCommentDelete.userId) &&
                Objects.equals(itemId, marketCommentDelete.itemId) &&
                Objects.equals(ownerId, marketCommentDelete.ownerId) &&
                Objects.equals(id, marketCommentDelete.id);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("MarketCommentDelete{");
        sb.append("userId=").append(userId);
        sb.append(", itemId=").append(itemId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
