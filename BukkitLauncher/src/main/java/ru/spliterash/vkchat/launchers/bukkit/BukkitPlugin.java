package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.wrappers.*;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

public class BukkitPlugin extends JavaPlugin implements Launcher {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        vkConfig = new BukkitConfig(new File(getDataFolder(), "config.yml"));
        VkChat.onEnable(this);
    }

    @Getter
    private AbstractConfig vkConfig;

    @Override
    public void onDisable() {
        VkChat.onDisable();
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
            players.add(new BukkitPlayer(onlinePlayer));
        }
        return players;
    }

    @Override
    public AbstractPlayer getPlayer(UUID uuid) {
        Player p = Bukkit.getPlayer(uuid);
        if (p != null)
            return new BukkitPlayer(p);
        else
            return null;
    }

    @Override
    public AbstractPlayer getPlayer(String nickname) {
        Player p = Bukkit.getPlayer(nickname);
        if (p != null)
            return new BukkitPlayer(p);
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
    public void registerListener(AbstractListener listener) {
        Bukkit.getPluginManager().registerEvents(new BukkitListener(listener), this);
    }

    @Override
    public void unregisterListener(AbstractListener listener) {
        if (listener instanceof BukkitListener) {
            BukkitListener bukkit = (BukkitListener) listener;
            HandlerList.unregisterAll(bukkit);
        }
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

}
