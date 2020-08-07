package ru.spliterash.vkchat.launchers.sponge.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import ru.spliterash.vkchat.launchers.sponge.SpongePlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;

public class SpongeJoinLeaveListener {
    private final IJoinLeaveListener listener;
    private final SpongePlugin plugin;

    public SpongeJoinLeaveListener(IJoinLeaveListener listener, SpongePlugin plugin) {
        this.listener = listener;
        this.plugin = plugin;
    }

    @Listener
    public void onJoin(ClientConnectionEvent.Join join, @First Player player) {
        listener.onJoin((AbstractPlayer) plugin.wrapSender(player), !player.hasPlayedBefore());
    }

    @Listener
    public void onLeave(ClientConnectionEvent.Disconnect disconnect, @First Player player) {
        listener.onExit((AbstractPlayer) plugin.wrapSender(player));
    }
}
