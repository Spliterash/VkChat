package ru.spliterash.vkchat.launchers.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.spliterash.vkchat.launchers.bukkit.BukkitPlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

public class BukkitMessageListener implements Listener {
    private final IMessageListener listener;

    public BukkitMessageListener(IMessageListener listener) {
        this.listener = listener;
    }

    @EventHandler(ignoreCancelled = true)
    public void onMessage(AsyncPlayerChatEvent e) {
        listener.onNewMessage((AbstractPlayer) BukkitPlugin.wrapSender(e.getPlayer()), e.getMessage());
    }
}
