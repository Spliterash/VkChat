package ru.spliterash.vkchat.listeners;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;

import static ru.spliterash.vkchat.utils.ListenerUtils.*;

public class JoinLeaveListener implements IJoinLeaveListener {
    @Override
    public void onJoin(AbstractPlayer player, boolean first) {
        if (noHasPerms(player))
            return;
        String message;
        if (first)
            message = Lang.PLAYER_JOIN_FIRST.toString();
        else
            message = Lang.PLAYER_JOIN.toString();
        processMessage(player, message);
    }


    @Override
    public void onExit(AbstractPlayer player) {
        if (noHasPerms(player))
            return;
        processMessage(player, Lang.PLAYER_EXIT.toString());
    }

}
