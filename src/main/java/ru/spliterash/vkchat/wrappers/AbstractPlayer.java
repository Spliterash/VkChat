package ru.spliterash.vkchat.wrappers;

import java.util.UUID;

public interface AbstractPlayer extends AbstractSender {
    boolean isOnline();
    UUID getUUID();
}
