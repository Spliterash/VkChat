package ru.spliterash.vkchat.launchers.console;

import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.launchers.Launcher;
import ru.spliterash.vkchat.obj.VkChatConfig;

import java.io.IOException;
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
    public VkChatConfig getVkConfig() {
        return new VkChatConfig() {
            private Integer peer;

            @Override
            public String getToken() {
                return "dec2e636cf2c22c757377b7c7e7c8ff11bed525a1fdad0fc12f1b808cb3c2430a5776d3e6518288f6d00d";
            }

            @Override
            public int getWait() {
                return 5000;
            }

            @Override
            public Integer getPeer() {
                return peer;
            }

            @Override
            public void setPeer(int peer) {
                this.peer = peer;
            }

            @Override
            public void save() throws IOException {
                //NO IMPL
            }
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

}
