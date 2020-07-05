package com.vk.api.sdk.objects.messages;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vk.api.sdk.objects.Validable;
import com.vk.api.sdk.objects.annotations.Required;
import java.util.Objects;

/**
 * KeyboardButton object
 */
public class KeyboardButton implements Validable {
    @SerializedName("action")
    @Required
    private KeyboardButtonAction action;

    /**
     * Button color
     */
    @SerializedName("color")
    private KeyboardButtonColor color;

    public KeyboardButtonAction getAction() {
        return action;
    }

    public KeyboardButton setAction(KeyboardButtonAction action) {
        this.action = action;
        return this;
    }

    public KeyboardButtonColor getColor() {
        return color;
    }

    public KeyboardButton setColor(KeyboardButtonColor color) {
        this.color = color;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, action);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyboardButton keyboardButton = (KeyboardButton) o;
        return Objects.equals(color, keyboardButton.color) &&
                Objects.equals(action, keyboardButton.action);
    }

    @Override
    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder("KeyboardButton{");
        sb.append("color='").append(color).append("'");
        sb.append(", action=").append(action);
        sb.append('}');
        return sb.toString();
    }
}
