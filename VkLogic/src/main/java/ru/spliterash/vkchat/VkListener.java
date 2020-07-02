package ru.spliterash.vkchat;

import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractListener;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public class VkListener implements AbstractListener {

    @Override
    public void onNewMessage(AbstractPlayer sender, String playerMessage) {
        if (noHasPerms(sender))
            return;
        if (VkChat.getInstance().getGlobalPeerUrl() != null)
            sendGlobal(Lang.USER_FORMAT
                    .toString(
                            "{user}", VkUtils.getPlayerToVk(sender),
                            "{message}", playerMessage
                    ));
    }


    @Override
    public void onJoin(AbstractPlayer player, boolean first) {
        if (noHasPerms(player))
            return;
        ConversationDao dao = Database.getDao(ConversationModel.class);
        //TODO
    }

    @Override
    public void onExit(AbstractPlayer player) {
        if (noHasPerms(player))
            return;
    }

    @Override
    public void onDie(AbstractPlayer player, String deathMessage) {
        if (noHasPerms(player))
            return;
    }

    private boolean noHasPerms(AbstractPlayer sender) {
        return !sender.hasPermission("vk.use");
    }

    private void sendGlobal(String text) {
        int peer = VkChat.getInstance().getGlobalPeer();
        VkChat.getInstance().sendMessage(peer, text);
    }
}
