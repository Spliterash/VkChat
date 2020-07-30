package ru.spliterash.vkchat.wrappers.listener;

import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public interface IMessageListener {
    void onNewMessage(AbstractPlayer sender, String message);
}
