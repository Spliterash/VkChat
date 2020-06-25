package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.configuration.file.FileConfiguration;
import ru.spliterash.vkchat.obj.VkChatConfig;

import java.io.File;
import java.io.IOException;

public class BukkitConfig extends VkChatConfig {
    private final BukkitPlugin plugin;
    private final FileConfiguration conf;

    BukkitConfig(BukkitPlugin plugin) {
        this.plugin = plugin;
        this.conf = plugin.getConfig();
    }

    @Override
    public String getToken() {
        return conf.getString("token");
    }

    @Override
    public int getWait() {
        return conf.getInt("wait", 5000);
    }

    @Override
    public Integer getPeer() {
        return conf.getInt("peer");
    }

    @Override
    public void setPeer(int peer) {
        conf.set("peer", peer);
    }

    @Override
    public void save() throws IOException {
        conf.save(new File(plugin.getDataFolder(), "config.yml"));
    }
}
