package ru.spliterash.vkchat.commands;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public class SetupExecutor implements SubExecutor {
    private final VkExecutor parent;

    public SetupExecutor(VkExecutor parent) {
        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        if (!player.hasPermission("vk.setup")) {
            player.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel link = base.getPlayerByUUID(player.getUUID());
        if (link == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        LinkHelper.start(player, LinkHelper.SetupType.CONVERSATION);

    }
}
