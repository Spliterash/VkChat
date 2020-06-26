package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import org.bukkit.command.CommandSender;
import ru.spliterash.vkchat.obj.AbstractSender;

public class BukkitSender implements AbstractSender {
    @Getter
    private final CommandSender executor;

    BukkitSender(CommandSender executor){
        this.executor = executor;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void sendMessage(String text) {

    }

    @Override
    public boolean hasPermission(String pex) {
        return false;
    }

    @Override
    public void sendJsonMessage(String json) {

    }
}
