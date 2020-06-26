package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.UUID;

public class BukkitPlayer extends BukkitSender implements AbstractPlayer {

    public BukkitPlayer(@NotNull Player player) {
        super(player);
    }

    public Player getPlayer() {
        return (Player) getExecutor();
    }

    public boolean isOnline() {
        return getPlayer().isOnline();
    }

    @Override
    public UUID getUUID() {
        return getPlayer().getUniqueId();
    }

}
