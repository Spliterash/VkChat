package ru.spliterash.vkchat.commands.subs;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.commands.SubExecutor;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.List;

public class SelectExecutor implements SubExecutor {
    private final VkExecutor parent;

    public SelectExecutor(VkExecutor parent) {

        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel pLink = base.getPlayerByUUID(player.getUUID());
        if (pLink == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        List<ConversationModel> playerConversations = base.getPlayerMemberConversation(pLink.getUUID());
        if (playerConversations.size() == 0) {
            player.sendMessage(Lang.NO_ANY_CONVERSATION.toComponent());
            return;
        }
        //Если челик хочет посмотреть лист
        if (args.length == 0) {
            parent.sendPlayerConversationList(player, playerConversations);
        } else {
            String strPeer = args[1];
            int peer;
            try {
                peer = Integer.parseInt(strPeer);
                if (!VkUtils.isConversation(peer))
                    throw new Exception();
            } catch (Exception ex) {
                player.sendMessage(ChatColor.RED + "-_-");
                return;
            }
            ConversationModel selected = playerConversations
                    .stream()
                    .filter(c -> c.getId() == peer)
                    .findFirst()
                    .orElse(null);
            if (selected == null) {
                player.sendMessage(ChatColor.RED + "Пашол нафиг отсюдова");
                return;
            }
            pLink.setSelectedConversation(selected.getId());
            pLink.saveOrUpdate();
            player.sendMessage(Lang.CONVERSATION_SELECTED.toString());
        }
    }
}
