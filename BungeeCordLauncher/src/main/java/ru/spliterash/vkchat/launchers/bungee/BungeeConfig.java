package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;

public class BungeeConfig implements AbstractConfig {
    private final Configuration config;
    private final File file;

    public BungeeConfig(File file) throws IOException {
        this.file = file;
        if (file.isFile())
            this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        else
            this.config = new Configuration(null);
    }

    @Override
    public Object get(String key) {
        return config.get(key);
    }

    @Override
    public void set(String key, Object value) {
        config.set(key, value);
    }

    @Override
    public void save() throws IOException {
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
    }
}
