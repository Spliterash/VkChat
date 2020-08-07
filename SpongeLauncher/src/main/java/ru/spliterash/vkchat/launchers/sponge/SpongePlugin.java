package ru.spliterash.vkchat.launchers.sponge;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.launchers.sponge.listeners.SpongeDieListener;
import ru.spliterash.vkchat.launchers.sponge.listeners.SpongeJoinLeaveListener;
import ru.spliterash.vkchat.launchers.sponge.listeners.SpongeMessageListener;
import ru.spliterash.vkchat.wrappers.*;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Plugin(id = "vkchat", name = "VkChat", version = "3.0")
public class SpongePlugin implements Launcher {
    private AbstractConfig config;

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    private void saveDefaultConfig() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = getClass().getClassLoader().getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path dataFolder;


    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        saveDefaultConfig();
        config = wrapConfig(new File(getDataFolder(), "config.yml"));
        VkChat.onEnable(this);
    }

    @Listener
    public void onServerStop(GameStoppedServerEvent e) {
        VkChat.onDisable(true);
    }

    @Override
    public java.util.logging.Logger getLogger() {
        return java.util.logging.Logger.getGlobal();
    }

    @Override
    public AbstractConfig getMainConfig() {
        return config;
    }

    @Override
    public AbstractConfig wrapConfig(File file) {
        return new SpongeConfig(file);
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        Task
                .builder()
                .async()
                .execute(runnable)
                .submit(this);
    }

    @Override
    public void unload() {
        //
    }

    @Override
    public File getDataFolder() {
        return dataFolder.toFile();
    }

    @Override
    public Collection<? extends AbstractPlayer> getOnlinePlayers() {
        return Sponge
                .getServer()
                .getOnlinePlayers()
                .stream()
                .map(SpongePlayer::new)
                .collect(Collectors.toSet());
    }

    @Override
    public AbstractPlayer getPlayer(UUID uuid) {
        return (AbstractPlayer) Sponge
                .getServer()
                .getPlayer(uuid)
                .map(this::wrapSender)
                .orElse(null);
    }

    @Override
    public AbstractPlayer getPlayer(String nickname) {
        return (AbstractPlayer) Sponge
                .getServer()
                .getPlayer(nickname)
                .map(this::wrapSender)
                .orElse(null);
    }

    @Override
    public void registerCommand(String command, AbstractCommandExecutor executor) {
        Sponge
                .getCommandManager()
                .register(this, new SpongeCommand(this, executor), command);
    }

    @Override
    public AbstractTask runTaskLater(Runnable runnable, int ticks) {
        return new SpongeTask(Task
                .builder()
                .delayTicks(ticks)
                .execute(runnable)
                .submit(this));
    }

    @Override
    public AbstractTask runTaskLaterAsync(Runnable runnable, int ticks) {
        return new SpongeTask(Task
                .builder()
                .async()
                .delayTicks(ticks)
                .execute(runnable)
                .submit(this));
    }

    @Override
    public void runTask(Runnable runnable) {
        Task
                .builder()
                .execute(runnable)
                .submit(this);
    }

    @Override
    public boolean isPrimaryThread() {
        return Sponge.getServer().isMainThread();
    }

    @Override
    public void registerListener(IMessageListener listener) {
        Sponge.getEventManager().registerListeners(this, new SpongeMessageListener(listener, this));
    }

    @Override
    public void registerListener(IJoinLeaveListener listener) {
        Sponge.getEventManager().registerListeners(this, new SpongeJoinLeaveListener(listener, this));
    }

    @Override
    public void registerListener(IDieListener listener) {
        Sponge.getEventManager().registerListeners(this, new SpongeDieListener(listener, this));
    }

    @Override
    public void unregisterListeners() {
        Sponge.getEventManager().unregisterPluginListeners(this);
    }

    @Override
    public void executeCommand(String sender, String command, Consumer<String[]> response) {
        Sponge.getCommandManager().process(new SpongeCommandSource(sender, response), command);
    }

    @Override
    public boolean isEnable() {
        return Sponge.getPluginManager().isLoaded("vkchat");
    }

    public AbstractSender wrapSender(CommandSource source) {
        if (source instanceof Player) {
            return new SpongePlayer((Player) source);
        } else {
            return new SpongeSender(source);
        }
    }
}
