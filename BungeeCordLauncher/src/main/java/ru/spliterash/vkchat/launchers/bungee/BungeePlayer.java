package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.UUID;

public class BungeePlayer extends BungeeSender implements AbstractPlayer{

    public BungeePlayer(ProxiedPlayer sender) {
        super(sender);
    }
    public ProxiedPlayer getPlayer(){
        return (ProxiedPlayer) super.getSender();
    }

    @Override
    public boolean isOnline() {
        return getPlayer().isConnected();
    }

    @Override
    public UUID getUUID() {
        return getPlayer().getUniqueId();
    }
}
