package ru.spliterash.vkchat.launchers.sponge;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;
import org.checkerframework.checker.nullness.qual.NonNull;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;

public class SpongeConfig implements AbstractConfig {
    private final File file;
    private final @NonNull ConfigurationNode conf;

    public SpongeConfig(File file) {
        try {
            this.file = file;
            if (!file.isFile())
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            conf = YAMLConfigurationLoader
                    .builder()
                    .setFile(file)
                    .build()
                    .load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object get(String key) {
        return conf.getNode(key).getValue();
    }

    @Override
    public void set(String key, Object value) {
        conf.getNode(key).setValue(value);
    }

    @Override
    public void save() throws IOException {
        YAMLConfigurationLoader
                .builder()
                .setFile(file)
                .build()
                .save(conf);
    }
}
