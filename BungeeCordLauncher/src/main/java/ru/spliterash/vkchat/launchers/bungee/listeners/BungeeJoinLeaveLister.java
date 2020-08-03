package ru.spliterash.vkchat.launchers.bungee.listeners;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import ru.spliterash.vkchat.launchers.bungee.BungeePlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;

public class BungeeJoinLeaveLister implements Listener {
    private final IJoinLeaveListener listener;

    public BungeeJoinLeaveLister(IJoinLeaveListener listener) {
        this.listener = listener;
    }

    @EventHandler
    public void onJoin(PostLoginEvent e) {
        listener.onJoin((AbstractPlayer) BungeePlugin.wrapSender(e.getPlayer()), false);
    }

    @EventHandler
    public void onLeave(PlayerDisconnectEvent e) {
        listener.onExit((AbstractPlayer) BungeePlugin.wrapSender(e.getPlayer()));
    }
}
