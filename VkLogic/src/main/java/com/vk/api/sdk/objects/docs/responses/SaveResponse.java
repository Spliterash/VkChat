package com.vk.api.sdk.objects.docs.responses;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.docs.Doc;
import com.vk.api.sdk.objects.docs.DocAttachmentType;
import com.vk.api.sdk.objects.messages.AudioMessage;
import com.vk.api.sdk.objects.messages.Graffiti;
import java.util.Objects;

/**
 * SaveResponse object
 */
public class SaveResponse implements Validable {
    @SerializedName("type")
    private DocAttachmentType type;

    @SerializedName("audio_message")
    private AudioMessage audioMessage;

    @SerializedName("doc")
    private Doc doc;

    @SerializedName("graffiti")
    private Graffiti graffiti;

    public DocAttachmentType getType() {
        return type;
    }

    public SaveResponse setType(DocAttachmentType type) {
        this.type = type;
        return this;
    }

    public AudioMessage getAudioMessage() {
        return audioMessage;
    }

    public SaveResponse setAudioMessage(AudioMessage audioMessage) {
        this.audioMessage = audioMessage;
        return this;
    }

    public Doc getDoc() {
        return doc;
    }

    public SaveResponse setDoc(Doc doc) {
        this.doc = doc;
        return this;
    }

    public Graffiti getGraffiti() {
        return graffiti;
    }

    public SaveResponse setGraffiti(Graffiti graffiti) {
        this.graffiti = graffiti;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doc, graffiti, type, audioMessage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveResponse saveResponse = (SaveResponse) o;
        return Objects.equals(doc, saveResponse.doc) &&
                Objects.equals(graffiti, saveResponse.graffiti) &&
                Objects.equals(type, saveResponse.type) &&
                Objects.equals(audioMessage, saveResponse.audioMessage);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("SaveResponse{");
        sb.append("doc=").append(doc);
        sb.append(", graffiti=").append(graffiti);
        sb.append(", type=").append(type);
        sb.append(", audioMessage=").append(audioMessage);
        sb.append('}');
        return sb.toString();
    }
}
