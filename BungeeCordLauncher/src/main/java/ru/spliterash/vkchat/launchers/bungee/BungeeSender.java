package ru.spliterash.vkchat.launchers.bungee;

import lombok.Getter;
import net.md_5.bungee.api.CommandSender;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

public class BungeeSender implements AbstractSender {
    @Getter
    private final CommandSender sender;

    public BungeeSender(CommandSender sender) {
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

    @Override
    public void sendMessage(BaseComponent... json) {
        String message = ComponentSerializer.toString(json);
        net.md_5.bungee.api.chat.BaseComponent[] components = net.md_5.bungee.chat.ComponentSerializer.parse(message);
        sender.sendMessage(components);
    }
}
