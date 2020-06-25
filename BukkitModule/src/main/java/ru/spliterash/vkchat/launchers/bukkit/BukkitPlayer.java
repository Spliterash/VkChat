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
    public void sendJsonMessage(BaseComponent... json) {
        player.spigot().sendMessage(json);
    }
}
