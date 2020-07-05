package com.vk.api.sdk.objects.orders;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * Subscription object
 */
public class Subscription implements Validable {
    /**
     * Cancel reason
     */
    @SerializedName("cancel_reason")
    private String cancelReason;

    /**
     * Date of creation in Unixtime
     */
    @SerializedName("create_time")
    private Integer createTime;

    /**
     * Subscription ID
     */
    @SerializedName("id")
    @Required
    private Integer id;

    /**
     * Subscription order item
     */
    @SerializedName("item_id")
    private String itemId;

    /**
     * Date of next bill in Unixtime
     */
    @SerializedName("next_bill_time")
    private Integer nextBillTime;

    /**
     * Pending cancel state
     */
    @SerializedName("pending_cancel")
    private Boolean pendingCancel;

    /**
     * Subscription period
     */
    @SerializedName("period")
    @Required
    private Integer period;

    /**
     * Date of last period start in Unixtime
     */
    @SerializedName("period_start_time")
    private Integer periodStartTime;

    /**
     * Subscription price
     */
    @SerializedName("price")
    @Required
    private Integer price;

    /**
     * Subscription status
     */
    @SerializedName("status")
    @Required
    private String status;

    /**
     * Is test subscription
     */
    @SerializedName("test_mode")
    private Boolean testMode;

    /**
     * Date of trial expire in Unixtime
     */
    @SerializedName("trial_expire_time")
    private Integer trialExpireTime;

    /**
     * Date of last change in Unixtime
     */
    @SerializedName("update_time")
    private Integer updateTime;

    public String getCancelReason() {
        return cancelReason;
    }

    public Subscription setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
        return this;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public Subscription setCreateTime(Integer createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Subscription setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getItemId() {
        return itemId;
    }

    public Subscription setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getNextBillTime() {
        return nextBillTime;
    }

    public Subscription setNextBillTime(Integer nextBillTime) {
        this.nextBillTime = nextBillTime;
        return this;
    }

    public Boolean getPendingCancel() {
        return pendingCancel;
    }

    public Subscription setPendingCancel(Boolean pendingCancel) {
        this.pendingCancel = pendingCancel;
        return this;
    }

    public Integer getPeriod() {
        return period;
    }

    public Subscription setPeriod(Integer period) {
        this.period = period;
        return this;
    }

    public Integer getPeriodStartTime() {
        return periodStartTime;
    }

    public Subscription setPeriodStartTime(Integer periodStartTime) {
        this.periodStartTime = periodStartTime;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Subscription setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Subscription setStatus(String status) {
        this.status = status;
        return this;
    }

    public Boolean getTestMode() {
        return testMode;
    }

    public Subscription setTestMode(Boolean testMode) {
        this.testMode = testMode;
        return this;
    }

    public Integer getTrialExpireTime() {
        return trialExpireTime;
    }

    public Subscription setTrialExpireTime(Integer trialExpireTime) {
        this.trialExpireTime = trialExpireTime;
        return this;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public Subscription setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pendingCancel, period, updateTime, trialExpireTime, itemId, createTime, price, testMode, nextBillTime, periodStartTime, id, cancelReason, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription subscription = (Subscription) o;
        return Objects.equals(period, subscription.period) &&
                Objects.equals(createTime, subscription.createTime) &&
                Objects.equals(itemId, subscription.itemId) &&
                Objects.equals(nextBillTime, subscription.nextBillTime) &&
                Objects.equals(trialExpireTime, subscription.trialExpireTime) &&
                Objects.equals(pendingCancel, subscription.pendingCancel) &&
                Objects.equals(periodStartTime, subscription.periodStartTime) &&
                Objects.equals(cancelReason, subscription.cancelReason) &&
                Objects.equals(updateTime, subscription.updateTime) &&
                Objects.equals(testMode, subscription.testMode) &&
                Objects.equals(price, subscription.price) &&
                Objects.equals(id, subscription.id) &&
                Objects.equals(status, subscription.status);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("Subscription{");
        sb.append("period=").append(period);
        sb.append(", createTime=").append(createTime);
        sb.append(", itemId='").append(itemId).append("'");
        sb.append(", nextBillTime=").append(nextBillTime);
        sb.append(", trialExpireTime=").append(trialExpireTime);
        sb.append(", pendingCancel=").append(pendingCancel);
        sb.append(", periodStartTime=").append(periodStartTime);
        sb.append(", cancelReason='").append(cancelReason).append("'");
        sb.append(", updateTime=").append(updateTime);
        sb.append(", testMode=").append(testMode);
        sb.append(", price=").append(price);
        sb.append(", id=").append(id);
        sb.append(", status='").append(status).append("'");
        sb.append('}');
        return sb.toString();
    }
}
