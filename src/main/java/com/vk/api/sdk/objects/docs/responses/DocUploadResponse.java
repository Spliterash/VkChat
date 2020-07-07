package com.vk.api.sdk.objects.docs.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import java.util.Objects;

/**
 * DocUploadResponse object
 */
public class DocUploadResponse implements Validable {
    /**
     * Uploaded file data
     */
    @SerializedName("file")
    private String file;

    public String getFile() {
        return file;
    }

    public DocUploadResponse setFile(String file) {
        this.file = file;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocUploadResponse docUploadResponse = (DocUploadResponse) o;
        return Objects.equals(file, docUploadResponse.file);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("DocUploadResponse{");
        sb.append("file='").append(file).append("'");
        sb.append('}');
        return sb.toString();
    }
}
