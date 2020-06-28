package ru.spliterash.vkchat.wrappers;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public interface AbstractSender {
    String getName();


    boolean hasPermission(String pex);

    void sendMessage(BaseComponent... json);

    default void sendMessage(String string) {
        sendMessage(TextComponent.fromLegacyText(string));
    }
}
