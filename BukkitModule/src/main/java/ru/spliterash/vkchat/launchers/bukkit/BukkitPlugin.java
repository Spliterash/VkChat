package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.launchers.Launcher;
import ru.spliterash.vkchat.obj.VkChatConfig;

public class BukkitPlugin extends JavaPlugin implements Launcher {
    @Getter
    private VkChatConfig vkConfig;

    @Override
    public void onEnable() {
        VkChat.onEnable(this);
        saveDefaultConfig();
        vkConfig = new BukkitConfig(this);
    }

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

}
