package ru.spliterash.vkchat.launchers.console;

import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.Launcher;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

public class ConsoleLauncher implements Launcher {
    @Override
    public Logger getLogger() {
        return Logger.getGlobal();
    }

    public static void main(String[] args) {
        ConsoleLauncher launcher = new ConsoleLauncher();
        VkChat.onEnable(launcher);
    }

    @Override
    public AbstractConfig getVkConfig() {
        return new AbstractConfig() {


            @Override
            public String get(String key) {
                switch (key) {
                    case "token":
                        return "dec2e636cf2c22c757377b7c7e7c8ff11bed525a1fdad0fc12f1b808cb3c2430a5776d3e6518288f6d00d";
                    case "peer":
                        return peer;
                    case "speed":
                        return "5000";
                    default:
                        return null;
                }
            }

            @Override
            public void set(String key, String value) {
                if (key.equals("peer"))
                    this.peer = value;
            }

            @Override
            public void save() throws IOException {
                //NO IMPL
            }

            private String peer;
        };
    }

    @Override
    public void runAsync(Runnable runnable) {
        new Thread(runnable).start();
    }

    @Override
    public void unload() {
        System.exit(0);
    }

    @Override
    public File getDataFolder() {
        File jarFile = null;
        try {
            jarFile = new File(
                    getClass()
                            .getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
                            .getPath()
            );

            return jarFile.getParentFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    ConsolePlayer player = new ConsolePlayer();

    @Override
    public Collection<? extends AbstractPlayer> getOnlinePlayers() {
        return Collections.singleton(player);
    }

    @Override
    public void registerCommand(String command, AbstractCommandExecutor executor) {
        //NOP
    }

}
