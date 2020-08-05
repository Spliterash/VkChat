package ru.spliterash.vkchat.wrappers;

import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

import java.io.File;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.logging.Logger;

public interface Launcher {

    Logger getLogger();

    AbstractConfig getMainConfig();

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

    void registerListener(IMessageListener listener);

    void registerListener(IJoinLeaveListener listener);

    void registerListener(IDieListener listener);

    void unregisterListeners();

    void executeCommand(String sender, String command, Consumer<String[]> response);


    default void dropAnvil(AbstractPlayer abstractPlayer, boolean storm) {
        //NOTHING
    }

    boolean isEnable();
}
