package ru.spliterash.vkchat.launchers.bungee.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import ru.spliterash.vkchat.launchers.bungee.BungeePlayer;
import ru.spliterash.vkchat.launchers.bungee.BungeePlugin;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

public class BungeeMessageListener implements Listener {
    private final IMessageListener listener;

    public BungeeMessageListener(IMessageListener listener) {
        this.listener = listener;
    }

    @EventHandler
    public void onChat(ChatEvent event) {
        if (event.getMessage().startsWith("/"))
            return;
        if (event.getSender() instanceof ProxiedPlayer) {
            BungeePlayer player = (BungeePlayer) BungeePlugin.wrapSender((ProxiedPlayer) event.getSender());
            listener.onNewMessage(player, event.getMessage());
        }
    }
}
