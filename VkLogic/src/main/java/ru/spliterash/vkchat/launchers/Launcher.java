package ru.spliterash.vkchat.launchers;

import ru.spliterash.vkchat.obj.AbstractConfig;
import ru.spliterash.vkchat.obj.AbstractPlayer;

import java.io.File;
import java.util.Collection;
import java.util.logging.Logger;

public interface Launcher {

    Logger getLogger();

    AbstractConfig getVkConfig();

    void runAsync(Runnable runnable);

    void unload();

    File getDataFolder();

    Collection<? extends AbstractPlayer> getOnlinePlayers();

}
