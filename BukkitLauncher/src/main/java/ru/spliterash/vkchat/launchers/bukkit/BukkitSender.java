package ru.spliterash.vkchat.launchers.bukkit;

import lombok.Getter;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import org.bukkit.command.CommandSender;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.util.Objects;

public class BukkitSender implements AbstractSender {
    @Getter
    private final CommandSender sender;

    BukkitSender(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public boolean hasPermission(String pex) {
        return sender.hasPermission(pex);
    }

    /**
     * Да кривовато, а как по другому ?
     */
    @Override
    public void sendMessage(BaseComponent... json) {
        String raw = ComponentSerializer.toString(json);
        net.md_5.bungee.api.chat.BaseComponent[] bukkitComponents = net.md_5.bungee.chat.ComponentSerializer.parse(raw);
        sender.spigot().sendMessage(bukkitComponents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukkitSender that = (BukkitSender) o;
        return Objects.equals(sender, that.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender);
    }
}
