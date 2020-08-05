package ru.spliterash.vkchat.vk;

import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ComponentBuilder;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageTree {
    private final List<BaseComponent[]> print;

    public MessageTree(Message message, BaseComponent... prefix) {
        print = new ArrayList<>(message.getFwdMessages().size() + 1);
        print.add(VkUtils.buildMessage(message.getFromId(), message.getText(),message.getAttachments() ,prefix));
        if (message.getFwdMessages().size() > 0)
            walk(message.getFwdMessages(), "");
        else if (message.getReplyMessage() != null) {
            walk(Collections.singletonList(message.getReplyMessage()), "");
        }
    }

    public BaseComponent[] getAll() {
        ComponentBuilder builder = new ComponentBuilder("");
        for (int i = 0; i < print.size(); i++) {
            BaseComponent[] component = print.get(i);
            if (i > 0 && i <= print.size() - 1)
                builder.append("\n", ComponentBuilder.FormatRetention.NONE);
            builder.append(component, ComponentBuilder.FormatRetention.NONE);
        }
        return builder.create();
    }

    private void walk(List<ForeignMessage> messageList, String prefix) {
        if (messageList == null)
            return;
        String color = ChatColor.GRAY.toString();
        for (int i = 0; i < messageList.size(); i++) {
            ForeignMessage message = messageList.get(i);
            BaseComponent[] messageComponents = VkUtils.buildMessage(message.getFromId(), message.getText(), message.getAttachments(), null);
            if (i - 1 == messageList.size() - 1) {
                BaseComponent[] prefixComponent = TextComponent.fromLegacyText(prefix + color + "└── ");
                BaseComponent[] array = ArrayUtils.putAll(BaseComponent.class, messageComponents, prefixComponent, 0);
                print.add(array);
                if (message.getFwdMessages() != null && message.getFwdMessages().size() > 0) {
                    walk(message.getFwdMessages(), prefix + "     ");
                }
            } else {
                print.add(ArrayUtils.putAll(BaseComponent.class, messageComponents, TextComponent.fromLegacyText(prefix + color + "├── "), 0));
                if (message.getFwdMessages() != null && message.getFwdMessages().size() > 0) {
                    walk(message.getFwdMessages(), prefix + color + "│    ");
                }
            }
        }
    }
}