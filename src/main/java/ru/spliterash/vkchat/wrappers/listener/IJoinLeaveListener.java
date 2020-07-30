package ru.spliterash.vkchat.wrappers.listener;

import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import static ru.spliterash.vkchat.utils.ListenerUtils.*;
public interface IJoinLeaveListener {
    void onJoin(AbstractPlayer player, boolean first);

    void onExit(AbstractPlayer player);

}
