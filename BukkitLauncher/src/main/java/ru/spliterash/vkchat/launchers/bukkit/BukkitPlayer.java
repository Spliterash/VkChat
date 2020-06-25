package ru.spliterash.vkchat.launchers.bukkit;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.obj.AbstractPlayer;

import java.util.Objects;

public class BukkitPlayer extends AbstractPlayer {
    private final Player player;

    public BukkitPlayer(@NotNull Player player) {
        this.player = Objects.requireNonNull(player);
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public void sendMessage(String text) {
        player.sendMessage(text);
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public boolean hasPermission(String pex) {
        return player.hasPermission(pex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukkitPlayer that = (BukkitPlayer) o;
        return Objects.equals(player, that.player);
    }

    @Override
    public int hashCode() {
        return player.hashCode();
    }

    @Override
    public void sendJsonMessage(BaseComponent... json) {
        player.spigot().sendMessage(json);
    }
}
