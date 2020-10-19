package ru.spliterash.vkchat.wrappers;

import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;

import java.util.List;

public interface AbstractSender {
    String getName();


    boolean hasPermission(String pex);

    void sendJsonMessage(String json);

    default void sendMessage(BaseComponent... json) {
        sendJsonMessage(ComponentSerializer.toString(json));
    }

    default void sendMessage(String string) {
        sendMessage(TextComponent.fromLegacyText(string));
    }

    default void sendMessage(List<BaseComponent[]> messages) {
        messages.forEach(this::sendMessage);
    }
}
