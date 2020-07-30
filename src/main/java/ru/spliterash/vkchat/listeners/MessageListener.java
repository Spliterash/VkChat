package ru.spliterash.vkchat.listeners;

import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.listener.IMessageListener;

import static ru.spliterash.vkchat.utils.ListenerUtils.*;

public class MessageListener implements IMessageListener {
    @Override
    public void onNewMessage(AbstractPlayer sender, String playerMessage) {
        if (noHasPerms(sender))
            return;
        if (VkChat.getInstance().getGlobalConversation() != null)
            sendGlobal(VkUtils.prepareMessage(sender, playerMessage));
    }
}
