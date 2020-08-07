package ru.spliterash.vkchat.launchers.sponge.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.message.MessageChannelEvent;
import ru.spliterash.vkchat.launchers.sponge.SpongePlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

public class SpongeMessageListener {
    private final IMessageListener listener;
    private final SpongePlugin plugin;

    public SpongeMessageListener(IMessageListener listener, SpongePlugin plugin) {
        this.listener = listener;
        this.plugin = plugin;
    }

    @Listener
    public void onMessage(MessageChannelEvent.Chat e, @First Player p) {
        listener.onNewMessage((AbstractPlayer) plugin.wrapSender(p), e.getFormatter().getBody().format().toPlain());
    }
}
