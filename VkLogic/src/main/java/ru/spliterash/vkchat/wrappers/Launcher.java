package ru.spliterash.vkchat.wrappers;

import net.md_5.bungee.api.chat.BaseComponent;

import java.io.File;
import java.util.Collection;
import java.util.UUID;
import java.util.logging.Logger;

public interface Launcher {

    Logger getLogger();

    AbstractConfig getVkConfig();

    void runAsync(Runnable runnable);

    void unload();

    File getDataFolder();

    Collection<? extends AbstractPlayer> getOnlinePlayers();

    AbstractPlayer getPlayer(UUID uuid);

    AbstractPlayer getPlayer(String nickname);

    void registerCommand(String command, AbstractCommandExecutor executor);

    default void sendAdmin(BaseComponent... message) {
        for (AbstractPlayer player : getOnlinePlayers()) {
            if (player.hasPermission("vkchat.admin")) {
                player.sendJsonMessage(message);
            }
        }
    }

    default void sendAll(BaseComponent... components) {
        for (AbstractPlayer player : getOnlinePlayers()) {
            player.sendJsonMessage(components);
        }
    }
}
