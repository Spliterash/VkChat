package ru.spliterash.vkchat.launchers.bukkit.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.spliterash.vkchat.launchers.bukkit.BukkitPlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

public class BukkitDieListener implements Listener {
    private final IDieListener listener;

    public BukkitDieListener(IDieListener listener) {
        this.listener = listener;
    }

    @EventHandler(ignoreCancelled = true)
    public void onMessage(PlayerDeathEvent e) {
        listener.onDie((AbstractPlayer) BukkitPlugin.wrapSender(e.getEntity()), ChatColor.stripColor(e.getDeathMessage()));
    }
}
