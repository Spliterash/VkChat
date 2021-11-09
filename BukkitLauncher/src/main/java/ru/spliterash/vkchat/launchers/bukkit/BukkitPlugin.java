package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import ru.spliterash.vkchat.HttpClientFactory;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.launchers.bukkit.listeners.BukkitDieListener;
import ru.spliterash.vkchat.launchers.bukkit.listeners.BukkitJoinLeaveListener;
import ru.spliterash.vkchat.launchers.bukkit.listeners.BukkitMessageListener;
import ru.spliterash.vkchat.wrappers.*;
import ru.spliterash.vkchat.wrappers.listener.IDieListener;
import ru.spliterash.vkchat.wrappers.listener.IJoinLeaveListener;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;

public class BukkitPlugin extends JavaPlugin implements Launcher {
    private final Map<CommandSender, BukkitSender> wrappers = new WeakHashMap<>();
    @Getter
    private static BukkitPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        vkConfig = wrapConfig(new File(getDataFolder(), "config.yml"));
        VkChat.onEnable(this, HttpClientFactory.get()); //Я всё понимаю, но переписывать всё очень долго, поэтому такой вот некрасивый костыль из модуля
    }

    @Getter
    private AbstractConfig vkConfig;

    @Override
    public AbstractConfig getMainConfig() {
        return vkConfig;
    }

    @Override
    public void onDisable() {
        VkChat.onDisable(true);
    }


    public static AbstractSender wrapSender(CommandSender commandSender) {
        return getInstance().wrappers.computeIfAbsent(commandSender, sender -> {
            if (sender instanceof Player)
                return new BukkitPlayer((Player) sender);
            else
                return new BukkitSender(sender);
        });

    }

    @Override
    public AbstractConfig wrapConfig(File file) {
        return new BukkitConfig(file);
    }

    @Override
    public void runTaskAsync(Runnable runnable) {
        Bukkit.getScheduler().runTaskAsynchronously(this, runnable);
    }

    @Override
    public void unload() {
        Bukkit.getPluginManager().disablePlugin(this);
    }

    @Override
    public Collection<? extends AbstractPlayer> getOnlinePlayers() {
        Set<BukkitPlayer> players = new HashSet<>();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            players.add((BukkitPlayer) wrapSender(onlinePlayer));
        }
        return players;
    }

    @Override
    public AbstractPlayer getPlayer(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        if (p != null)
            return (AbstractPlayer) wrapSender(p);
        else
            return null;
    }

    @Override
    public AbstractPlayer getPlayer(String nickname) {
        Player p = Bukkit.getPlayer(nickname);
        if (p != null)
            return (AbstractPlayer) wrapSender(p);
        else
            return null;
    }

    @Override
    public void registerCommand(String command, AbstractCommandExecutor executor) {
        PluginCommand cmd = getCommand(command);
        BukkitCommand bukkitExecutor = new BukkitCommand(executor);
        cmd.setExecutor(bukkitExecutor);
        cmd.setTabCompleter(bukkitExecutor);
    }

    @Override
    public AbstractTask runTaskLater(Runnable runnable, int ticks) {
        BukkitTask task = getServer().getScheduler().runTaskLater(this, runnable, ticks);
        return new BukkitTaskImpl(task);
    }

    @Override
    public AbstractTask runTaskLaterAsync(Runnable runnable, int ticks) {
        BukkitTask task = getServer().getScheduler().runTaskLaterAsynchronously(this, runnable, ticks);
        return new BukkitTaskImpl(task);
    }

    @Override
    public void runTask(Runnable runnable) {
        getServer().getScheduler().runTask(this, runnable);
    }

    @Override
    public boolean isPrimaryThread() {
        return getServer().isPrimaryThread();
    }

    @Override
    public void registerListener(IMessageListener listener) {
        getServer().getPluginManager().registerEvents(new BukkitMessageListener(listener), this);
    }

    @Override
    public void registerListener(IJoinLeaveListener listener) {
        getServer().getPluginManager().registerEvents(new BukkitJoinLeaveListener(listener), this);
    }

    @Override
    public void registerListener(IDieListener listener) {
        getServer().getPluginManager().registerEvents(new BukkitDieListener(listener), this);
    }


    @Override
    public void unregisterListeners() {
        HandlerList.unregisterAll(this);
    }

    @Override
    public void executeCommand(String sender, String command, Consumer<String[]> response) {
        BukkitCommandSender commandSender = new BukkitCommandSender(sender, response);
        try {
            Bukkit.dispatchCommand(commandSender, command);
        } catch (CommandException ex) {
            response.accept(null);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }

    @Override
    public boolean isEnable() {
        return super.isEnabled();
    }
}
