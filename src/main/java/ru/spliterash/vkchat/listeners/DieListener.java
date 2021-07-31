package ru.spliterash.vkchat.listeners;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;

import static ru.spliterash.vkchat.utils.ListenerUtils.*;

public class DieListener implements IDieListener {
    @Override
    public void onDie(AbstractPlayer player, String deathMessage) {
        if (noHasPerms(player))
            return;
        if (deathMessage == null)
            deathMessage = Lang.DEATH.toString();
        processMessage(player, deathMessage.replace(player.getName(), "{player}"));
    }
}
