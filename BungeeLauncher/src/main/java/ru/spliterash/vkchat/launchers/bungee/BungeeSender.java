package ru.spliterash.vkchat.launchers.bungee;

import lombok.Getter;
import net.md_5.bungee.api.CommandSender;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.util.Objects;

public class BungeeSender implements AbstractSender {
    @Getter
    private final CommandSender sender;

    public BungeeSender(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BungeeSender that = (BungeeSender) o;
        return Objects.equals(sender, that.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender);
    }

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public boolean hasPermission(String pex) {
        return sender.hasPermission(pex);
    }

    @Override
    public void sendJsonMessage(String json) {
        net.md_5.bungee.api.chat.BaseComponent[] components = net.md_5.bungee.chat.ComponentSerializer.parse(json);
        sender.sendMessage(components);
    }

}
