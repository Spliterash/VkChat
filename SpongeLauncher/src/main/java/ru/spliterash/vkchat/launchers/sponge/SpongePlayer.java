package ru.spliterash.vkchat.launchers.sponge;

import org.spongepowered.api.entity.living.player.Player;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.UUID;

public class SpongePlayer extends SpongeSender implements AbstractPlayer {
    public SpongePlayer(Player p) {
        super(p);
    }

    public Player getPlayer() {
        return (Player) super.getSender();
    }

    @Override
    public boolean isOnline() {
        return getPlayer().isOnline();
    }

    @Override
    public UUID getUUID() {
        return getPlayer().getUniqueId();
    }
}
