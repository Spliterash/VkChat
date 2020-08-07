package ru.spliterash.vkchat.launchers.sponge.listeners;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import ru.spliterash.vkchat.launchers.sponge.SpongePlugin;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;

public class SpongeDieListener {
    private final IDieListener listener;
    private final SpongePlugin plugin;

    public SpongeDieListener(IDieListener listener, SpongePlugin plugin) {
        this.listener = listener;
        this.plugin = plugin;
    }

    @Listener
    public void onDie(DestructEntityEvent.Death e, @First Player player) {
        listener.onDie((AbstractPlayer) plugin.wrapSender(player), e.getMessage().toPlain());
    }
}
