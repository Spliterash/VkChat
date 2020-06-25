package ru.spliterash.vkchat.obj;

import net.md_5.bungee.api.chat.BaseComponent;

public abstract class AbstractPlayer {
    public abstract String getName();

    public abstract void sendMessage(String text);

    public abstract boolean isOnline();

    public abstract boolean hasPermission(String pex);

    public abstract void sendJsonMessage(BaseComponent... components);
}
