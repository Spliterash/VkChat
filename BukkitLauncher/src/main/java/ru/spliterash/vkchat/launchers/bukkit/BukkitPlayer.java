package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.obj.AbstractPlayer;

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

}
