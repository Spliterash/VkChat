package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.command.CommandSender;
import ru.spliterash.vkchat.wrappers.AbstractSender;

public class BukkitSender implements AbstractSender {
    @Getter
    private final CommandSender executor;

    BukkitSender(CommandSender executor) {
        this.executor = executor;
    }

    @Override
    public String getName() {
        return executor.getName();
    }

    @Override
    public void sendMessage(String text) {
        executor.sendMessage(text);
    }

    @Override
    public boolean hasPermission(String pex) {
        return executor.hasPermission(pex);
    }

    @Override
    public void sendMessage(BaseComponent... json) {
        executor.spigot().sendMessage(json);
    }
}
