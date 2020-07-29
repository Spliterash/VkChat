package ru.spliterash.vkchat.commands.subs;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.commands.SubExecutor;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public class LinkExecutor implements SubExecutor {
    private final VkExecutor parent;

    public LinkExecutor(VkExecutor parent) {

        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel link = base.getPlayerByUUID(player.getUUID());
        if (link != null) {
            VkChat.getInstance().userAction(String.valueOf(link.getVk()), (u) -> player.sendMessage(
                    ChatBuilder.compile(
                            Lang.ALREADY_LINK.toString(),
                            ArrayUtils.createMap("{user}",
                                    new BaseComponent[]{VkUtils.getUserComponent(u)})
                    )
            ));
        } else {
            LinkHelper.start(player, LinkHelper.SetupType.PROFILE);
        }
    }
}
