package ru.spliterash.vkchat.obj;

import java.io.IOException;


public abstract class VkChatConfig {
    private String token;
    private int speed;
    private Integer peer;

    public abstract String getToken();

    public abstract int getWait();

    public abstract Integer getPeer();

    public abstract void setPeer(int peer);

    public abstract void save() throws IOException;

}
