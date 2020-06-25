package ru.spliterash.vkchat.launchers;

import ru.spliterash.vkchat.obj.VkChatConfig;

import java.util.logging.Logger;

public interface Launcher {

    Logger getLogger();

    VkChatConfig getVkConfig();

    void runAsync(Runnable runnable);

    void unload();

}
