package ru.spliterash.vkchat.commands.subs;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.commands.SubExecutor;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public class UnLinkExecutor implements SubExecutor {
    private final VkExecutor parent;

    public UnLinkExecutor(VkExecutor parent) {
        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel model;

        model = base.getPlayerByUUID(player.getUUID());
        if (model == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        model.delete();
        player.sendMessage(Lang.OK.toString());
    }
}
