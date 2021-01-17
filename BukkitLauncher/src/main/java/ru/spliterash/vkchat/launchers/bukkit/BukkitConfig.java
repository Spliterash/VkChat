package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.configuration.file.YamlConfiguration;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BukkitConfig implements AbstractConfig {
    private final File confFile;
    private final YamlConfiguration conf;

    BukkitConfig(File conf) {
        this.confFile = conf;
        this.conf = YamlConfiguration.loadConfiguration(confFile);
    }

    @Override
    public String getString(String key) {
        return conf.getString(key);
    }

    @Override
    public Object get(String key) {
        return conf.get(key);
    }

    @Override
    public void set(String key, Object value) {
        conf.set(key, value);
    }

    @Override
    public void save() throws IOException {
        conf.save(confFile);
    }

    @Override
    public List<String> getStringList(String key) {
        return conf.getStringList(key);
    }
}
