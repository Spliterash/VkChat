package com.vk.api.sdk.objects.groups;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * CallbackServer object
 */
public class CallbackServer implements Validable {
    @SerializedName("id")
    @Required
    private Integer id;

    @SerializedName("title")
    @Required
    private String title;

    @SerializedName("creator_id")
    private Integer creatorId;

    @SerializedName("url")
    @Required
    private String url;

    @SerializedName("secret_key")
    private String secretKey;

    @SerializedName("status")
    @Required
    private CallbackServerStatus status;

    public Integer getId() {
        return id;
    }

    public CallbackServer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CallbackServer setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public CallbackServer setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CallbackServer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public CallbackServer setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public CallbackServerStatus getStatus() {
        return status;
    }

    public CallbackServer setStatus(CallbackServerStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(secretKey, creatorId, id, title, url, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallbackServer callbackServer = (CallbackServer) o;
        return Objects.equals(secretKey, callbackServer.secretKey) &&
                Objects.equals(creatorId, callbackServer.creatorId) &&
                Objects.equals(id, callbackServer.id) &&
                Objects.equals(title, callbackServer.title) &&
                Objects.equals(url, callbackServer.url) &&
                Objects.equals(status, callbackServer.status);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("CallbackServer{");
        sb.append("secretKey='").append(secretKey).append("'");
        sb.append(", creatorId=").append(creatorId);
        sb.append(", id=").append(id);
        sb.append(", title='").append(title).append("'");
        sb.append(", url='").append(url).append("'");
        sb.append(", status='").append(status).append("'");
        sb.append('}');
        return sb.toString();
    }
}
