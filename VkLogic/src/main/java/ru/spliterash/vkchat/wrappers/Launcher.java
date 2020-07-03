package ru.spliterash.vkchat.wrappers;

import net.md_5.bungee.api.chat.BaseComponent;

import java.io.File;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.logging.Logger;

public interface Launcher {

    Logger getLogger();

    AbstractConfig getVkConfig();

    AbstractConfig wrapConfig(File file);

    void runTaskAsync(Runnable runnable);

    void unload();

    File getDataFolder();

    Collection<? extends AbstractPlayer> getOnlinePlayers();

    AbstractPlayer getPlayer(UUID uuid);

    AbstractPlayer getPlayer(String nickname);

    void registerCommand(String command, AbstractCommandExecutor executor);

    default void sendAdmin(BaseComponent... message) {
        for (AbstractPlayer player : getOnlinePlayers()) {
            if (player.hasPermission("vkchat.admin")) {
                player.sendMessage(message);
            }
        }
    }

    AbstractTask runTaskLater(Runnable runnable, int ticks);

    AbstractTask runTaskLaterAsync(Runnable runnable, int ticks);

    default void sendAll(BaseComponent... components) {
        for (AbstractPlayer player : getOnlinePlayers()) {
            player.sendMessage(components);
        }
    }

    void runTask(Runnable runnable);

    boolean isPrimaryThread();

    void registerListener(AbstractListener listener);

    void unregisterListener(AbstractListener listener);

    void unregisterListeners();

    void executeCommand(String sender, String command, Consumer<String[]> response);
}
