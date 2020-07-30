package ru.spliterash.vkchat.wrappers.listener;

import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public interface IDieListener {
    void onDie(AbstractPlayer player, String deathMessage);
}
