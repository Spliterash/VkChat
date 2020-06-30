package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.spliterash.vkchat.wrappers.AbstractListener;

public class BukkitListener implements Listener {
    private final AbstractListener listener;

    public BukkitListener(AbstractListener listener) {
        this.listener = listener;
    }


    @EventHandler(ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent e) {
        listener.onNewMessage(new BukkitPlayer(e.getPlayer()), e.getMessage());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        listener.onJoin(new BukkitPlayer(e.getPlayer()), e.getPlayer().hasPlayedBefore());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        listener.onExit(new BukkitPlayer(e.getPlayer()));
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        listener.onDie(new BukkitPlayer(e.getEntity()), e.getDeathMessage());
    }
}
