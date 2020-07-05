package com.vk.api.sdk.objects.gifts;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * Gift object
 */
public class Gift implements Validable {
    /**
     * Date when gist has been sent in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Gift sender ID
     */
    @SerializedName("from_id")
    private Integer fromId;

    @SerializedName("gift")
    private Layout gift;

    /**
     * Hash
     */
    @SerializedName("gift_hash")
    private String giftHash;

    /**
     * Gift ID
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Comment text
     */
    @SerializedName("message")
    private String message;

    @SerializedName("privacy")
    private GiftPrivacy privacy;

    public Integer getDate() {
        return date;
    }

    public Gift setDate(Integer date) {
        this.date = date;
        return this;
    }

    public Integer getFromId() {
        return fromId;
    }

    public Gift setFromId(Integer fromId) {
        this.fromId = fromId;
        return this;
    }

    public Layout getGift() {
        return gift;
    }

    public Gift setGift(Layout gift) {
        this.gift = gift;
        return this;
    }

    public String getGiftHash() {
        return giftHash;
    }

    public Gift setGiftHash(String giftHash) {
        this.giftHash = giftHash;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Gift setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Gift setMessage(String message) {
        this.message = message;
        return this;
    }

    public GiftPrivacy getPrivacy() {
        return privacy;
    }

    public Gift setPrivacy(GiftPrivacy privacy) {
        this.privacy = privacy;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, gift, giftHash, privacy, id, message, fromId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(date, gift.date) &&
                Objects.equals(gift, gift.gift) &&
                Objects.equals(giftHash, gift.giftHash) &&
                Objects.equals(fromId, gift.fromId) &&
                Objects.equals(privacy, gift.privacy) &&
                Objects.equals(id, gift.id) &&
                Objects.equals(message, gift.message);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Gift{");
        sb.append("date=").append(date);
        sb.append(", gift=").append(gift);
        sb.append(", giftHash='").append(giftHash).append("'");
        sb.append(", fromId=").append(fromId);
        sb.append(", privacy=").append(privacy);
        sb.append(", id=").append(id);
        sb.append(", message='").append(message).append("'");
        sb.append('}');
        return sb.toString();
    }
}
