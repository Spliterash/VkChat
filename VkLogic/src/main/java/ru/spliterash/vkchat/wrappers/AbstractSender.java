package ru.spliterash.vkchat.wrappers;

import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;

public interface AbstractSender {
    String getName();


    boolean hasPermission(String pex);


    void sendMessage(BaseComponent... json);

    default void sendMessage(String string) {
        sendMessage(TextComponent.fromLegacyText(string));
    }
}
