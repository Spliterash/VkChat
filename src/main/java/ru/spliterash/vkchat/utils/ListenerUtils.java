package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.listeners.DieListener;
import ru.spliterash.vkchat.listeners.JoinLeaveListener;
import ru.spliterash.vkchat.listeners.MessageListener;
import ru.spliterash.vkchat.wrappers.AbstractConfig;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.Launcher;

import java.util.List;

@UtilityClass
public class ListenerUtils {
    public boolean noHasPerms(AbstractPlayer sender) {
        return !sender.hasPermission("vk.use");
    }

    public void sendGlobal(String text) {
        ConversationModel peer = VkChat.getInstance().getGlobalConversation();
        if (peer != null)
            VkChat.getInstance().sendMessage(peer.getId(), text);
    }

    public void processMessage(AbstractPlayer player, String message) {
        VkChat.getInstance().getLauncher().runTaskAsync(() -> {
            PlayerModel pModel = DatabaseLoader.getBase().getPlayerByUUID(player.getUUID());
            List<ConversationModel> list = null;
            String vkName = VkUtils.getPlayerToVk(player);
            String msg = message.replace("{player}", vkName);
            if (pModel != null) {
                list = VkUtils.sendPlayerPeerMessage(pModel, msg);
            }
            if (list == null || list.stream().noneMatch(l -> l.getId() == VkChat.getInstance().getGlobalConversation().getId()))
                sendGlobal(msg);
        });

    }

    public void registerListeners(AbstractConfig config) {
        Launcher launcher = VkChat.getInstance().getLauncher();
        launcher.registerListener(new MessageListener());
        if (config.getBoolean("join_message", false))
            launcher.registerListener(new JoinLeaveListener());
        if (config.getBoolean("die_message", false))
            launcher.registerListener(new DieListener());
    }
}
