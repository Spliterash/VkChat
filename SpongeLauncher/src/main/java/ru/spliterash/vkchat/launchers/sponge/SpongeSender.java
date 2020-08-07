package ru.spliterash.vkchat.launchers.sponge;

import lombok.Getter;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;
import ru.spliterash.vkchat.wrappers.AbstractSender;

public class SpongeSender implements AbstractSender {
    @Getter
    private final CommandSource sender;

    public SpongeSender(CommandSource source) {
        this.sender = source;
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
        Text text = TextSerializers.JSON.deserialize(json);
        sender.sendMessage(text);
    }
}
