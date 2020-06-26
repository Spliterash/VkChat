package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.configuration.file.FileConfiguration;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;

public class BukkitConfig implements AbstractConfig {
    private final BukkitPlugin plugin;
    private final FileConfiguration conf;

    BukkitConfig(BukkitPlugin plugin) {
        this.plugin = plugin;
        this.conf = plugin.getConfig();
    }

    @Override
    public String get(String key) {
        return conf.getString(key);
    }

    @Override
    public void set(String key, String value) {
        conf.set(key, value);
    }

    @Override
    public void save() throws IOException {
        conf.save(new File(plugin.getDataFolder(), "config.yml"));
    }
}
