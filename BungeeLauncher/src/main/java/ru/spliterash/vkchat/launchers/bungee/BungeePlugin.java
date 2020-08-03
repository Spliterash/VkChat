package ru.spliterash.vkchat.launchers.bungee;

import lombok.Getter;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.launchers.bungee.listeners.BungeeJoinLeaveLister;
import ru.spliterash.vkchat.launchers.bungee.listeners.BungeeMessageListener;
import ru.spliterash.vkchat.wrappers.*;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class BungeePlugin extends Plugin implements Launcher {
    private final Map<CommandSender, BungeeSender> wrappers = new WeakHashMap<>();
    @Getter
    private static BungeePlugin instance;
    private AbstractConfig vkConfig;
    private final Map<String, BungeeCommandExecutor> executors = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        vkConfig = wrapConfig(new File(getDataFolder(), "config.yml"));
        getProxy().getPluginManager().registerListener(this, new TabCompleteListener());
        VkChat.onEnable(this);
    }

    @Override
    public void onDisable() {
        VkChat.onDisable(true);
    }

    public BungeeCommandExecutor getExecutor(String command) {
        return executors.get(command);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void saveDefaultConfig() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static BungeeSender wrapSender(CommandSender commandSender) {
        return getInstance().wrappers.computeIfAbsent(commandSender, sender -> {
            if (sender instanceof ProxiedPlayer)
                return new BungeePlayer((ProxiedPlayer) sender);
            else
                return new BungeeSender(sender);
        });

    }

    @Override
    public AbstractConfig getMainConfig() {
        return vkConfig;
    }

    @Override
    public AbstractConfig wrapConfig(File file) {
        try {
            return new BungeeConfig(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        getProxy().getScheduler().runAsync(this, runnable);
    }

    @Override
    public void unload() {
        getProxy().getPluginManager().unregisterListeners(this);
        getProxy().getPluginManager().unregisterCommands(this);
        //Just unregister all, because bungee does not have unload
    }

    @Override
    public Collection<? extends AbstractPlayer> getOnlinePlayers() {
        Set<BungeePlayer> players = new HashSet<>();
        for (ProxiedPlayer player : getProxy().getPlayers()) {
            players.add((BungeePlayer) wrapSender(player));
        }
        return players;
    }

    @Override
    public AbstractPlayer getPlayer(UUID uuid) {
        ProxiedPlayer player = getProxy().getPlayer(uuid);
        if (player != null)
            return (AbstractPlayer) wrapSender(player);
        else
            return null;
    }

    @Override
    public AbstractPlayer getPlayer(String nickname) {
        ProxiedPlayer player = getProxy().getPlayer(nickname);
        if (player != null)
            return (AbstractPlayer) wrapSender(player);
        else
            return null;
    }


    @Override
    public void registerCommand(String command, AbstractCommandExecutor executor) {
        BungeeCommandExecutor bungeeExecutor = new BungeeCommandExecutor(command, executor);
        getProxy().getPluginManager().registerCommand(this, bungeeExecutor);
        executors.put(command, bungeeExecutor);
    }

    @Override
    public AbstractTask runTaskLater(Runnable runnable, int ticks) {
        return new BungeeTask(getProxy().getScheduler().schedule(this, runnable, ticks * 50, TimeUnit.MILLISECONDS));
    }

    @Override
    public AbstractTask runTaskLaterAsync(Runnable runnable, int ticks) {
        //В банже вообще похеру
        return runTaskLater(runnable, ticks);
    }

    @Override
    public void runTask(Runnable runnable) {
        runnable.run();
    }

    @Override
    public boolean isPrimaryThread() {
        //В банже всё ASYNC
        return true;
    }

    @Override
    public void registerListener(IMessageListener listener) {
        getProxy().getPluginManager().registerListener(this, new BungeeMessageListener(listener));
    }

    @Override
    public void registerListener(IJoinLeaveListener listener) {
        getProxy().getPluginManager().registerListener(this, new BungeeJoinLeaveLister(listener));
    }

    @Override
    public void registerListener(IDieListener listener) {
        //JUST NO
    }

    @Override
    public void unregisterListeners() {
        getProxy().getPluginManager().unregisterListeners(this);
    }

    @Override
    public void executeCommand(String sender, String command, Consumer<String[]> response) {
        getProxy().getPluginManager().dispatchCommand(new BungeeCommandSender(sender, response), command);
    }
}
