package ru.spliterash.vkchat.wrappers;

import net.md_5.bungee.api.chat.BaseComponent;

public interface AbstractSender {
    String getName();

    void sendMessage(String text);

    boolean hasPermission(String pex);

    void sendJsonMessage(BaseComponent... json);
}
