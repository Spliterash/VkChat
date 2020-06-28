package ru.spliterash.vkchat.vk;

import com.vk.api.sdk.objects.messages.ForeignMessage;
import com.vk.api.sdk.objects.messages.Message;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MessageTree {
    private final List<BaseComponent[]> print;

    public MessageTree(Message message, String url) {
        print = new ArrayList<>(message.getFwdMessages().size() + 1);
        print.add(VkUtils.buildMessage(message.getFromId(), message.getText(), url));
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
            if (i < print.size() - 1)
                builder.append("\n", ComponentBuilder.FormatRetention.NONE);
            builder.append(component, ComponentBuilder.FormatRetention.NONE);
        }
        return builder.create();
    }

    private void walk(List<ForeignMessage> messageList, String prefix) {
        if (messageList == null)
            return;
        Iterator<ForeignMessage> iter = messageList.iterator();
        int i = 0;
        String color = ChatColor.GRAY.toString();
        while (iter.hasNext()) {
            i++;
            ForeignMessage message = iter.next();
            BaseComponent[] messageComponents = VkUtils.buildMessage(message.getFromId(), message.getText(), null);
            if (i - 1 == messageList.size() - 1) {
                print.add(ArrayUtils.putAll(messageComponents, TextComponent.fromLegacyText(prefix + color + "└── "), 0));
                if (message.getFwdMessages().size() > 0) {
                    walk(message.getFwdMessages(), prefix + "     ");
                }
            } else {
                print.add(ArrayUtils.putAll(messageComponents, TextComponent.fromLegacyText(prefix + color + "├── "), 0));
                if (message.getFwdMessages().size() > 0) {
                    walk(message.getFwdMessages(), prefix + color + "│    ");
                }
            }
        }
    }
}