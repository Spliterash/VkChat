package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.obj.AbstractCommandExecutor;
import ru.spliterash.vkchat.obj.Launcher;
import ru.spliterash.vkchat.obj.AbstractConfig;
import ru.spliterash.vkchat.obj.AbstractPlayer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BukkitPlugin extends JavaPlugin implements Launcher {

    @Override
    public void onEnable() {
        VkChat.onEnable(this);
        saveDefaultConfig();
        vkConfig = new BukkitConfig(this);
    }

    @Getter
    private AbstractConfig vkConfig;

    @Override
    public void onDisable() {
        VkChat.onDisable();
    }

    @Override
    public void runAsync(Runnable runnable) {
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
    public void registerCommand(String command, AbstractCommandExecutor executor) {
        PluginCommand cmd = getCommand(command);
        BukkitCommand bukkitExecutor = new BukkitCommand(executor);
        cmd.setExecutor(bukkitExecutor);
        cmd.setTabCompleter(bukkitExecutor);
    }

}
