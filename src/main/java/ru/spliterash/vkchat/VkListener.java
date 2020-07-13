package ru.spliterash.vkchat;

import lombok.SneakyThrows;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractListener;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.sql.SQLException;

public class VkListener implements AbstractListener {

    @Override
    public void onNewMessage(AbstractPlayer sender, String playerMessage) {
        if (noHasPerms(sender))
            return;
        if (VkChat.getInstance().getGlobalPeerUrl() != null)
            sendGlobal(VkUtils.prepareMessage(sender, playerMessage));
    }

    private void processMessage(AbstractPlayer player, String message) throws SQLException {
        PlayerDao playerDao = Database.getDao(PlayerModel.class);
        String vkName = VkUtils.getPlayerToVk(player);
        sendGlobal(message
                .replace("{player}", vkName));
        PlayerModel pModel = playerDao.queryForId(player.getUUID());
        if (pModel != null) {
            VkUtils.sendPlayerPeerMessage(pModel, message);
        }
    }

    @SneakyThrows
    @Override
    public void onJoin(AbstractPlayer player, boolean first) {
        if (noHasPerms(player))
            return;
        String message;
        if (first)
            message = Lang.PLAYER_JOIN_FIRST.toString();
        else
            message = Lang.PLAYER_JOIN.toString();
        processMessage(player, message);
    }

    @SneakyThrows
    @Override
    public void onExit(AbstractPlayer player) {
        if (noHasPerms(player))
            return;
        processMessage(player, Lang.PLAYER_EXIT.toString());
    }

    @SneakyThrows
    @Override
    public void onDie(AbstractPlayer player, String deathMessage) {
        if (noHasPerms(player))
            return;
        processMessage(player, "{player}: " + deathMessage);
    }

    private boolean noHasPerms(AbstractPlayer sender) {
        return !sender.hasPermission("vk.use");
    }

    private void sendGlobal(String text) {
        int peer = VkChat.getInstance().getGlobalPeer();
        if (VkUtils.isConversation(peer))
            VkChat.getInstance().sendMessage(peer, text);
    }
}
