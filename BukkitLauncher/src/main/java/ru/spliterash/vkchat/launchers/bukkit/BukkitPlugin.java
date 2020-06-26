package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.Launcher;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

}
