package com.vk.api.sdk.objects.messages.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * GetInviteLinkResponse object
 */
public class GetInviteLinkResponse implements Validable {
    @SerializedName("link")
    private String link;

    public String getLink() {
        return link;
    }

    public GetInviteLinkResponse setLink(String link) {
        this.link = link;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(link);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetInviteLinkResponse getInviteLinkResponse = (GetInviteLinkResponse) o;
        return Objects.equals(link, getInviteLinkResponse.link);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("GetInviteLinkResponse{");
        sb.append("link='").append(link).append("'");
        sb.append('}');
        return sb.toString();
    }
}
