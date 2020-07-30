package ru.spliterash.vkchat.launchers.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.spliterash.vkchat.launchers.bukkit.BukkitPlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;

public class BukkitJoinLeaveListener implements Listener {
    private final IJoinLeaveListener listener;

    public BukkitJoinLeaveListener(IJoinLeaveListener listener) {
        this.listener = listener;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        listener.onJoin((AbstractPlayer) BukkitPlugin.wrapSender(e.getPlayer()), !e.getPlayer().hasPlayedBefore());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        listener.onExit((AbstractPlayer) BukkitPlugin.wrapSender(e.getPlayer()));
    }
}
