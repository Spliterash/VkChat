package ru.spliterash.vkchat.commands.subs;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.commands.SubExecutor;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

public class CreateNewConversationExecutor implements SubExecutor {
    private final VkExecutor parent;

    public CreateNewConversationExecutor(VkExecutor parent) {
        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        LinkHelper setup = LinkHelper.getSetup(player);
        if (setup == null) {
            player.sendMessage(Lang.SETUP_NOT_IN_PROGRESS.toComponent());
            return;
        }
        PlayerModel playerModel;
        AbstractBase base = DatabaseLoader.getBase();

        playerModel = base.getPlayerByUUID(player.getUUID());
        if (playerModel == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        setup.destroy();
        VkChat vk = VkChat.getInstance();
        vk.getLauncher().runTaskAsync(() -> {
            try {
                int peer = VkUtils.createNewConversation();
                String link = VkUtils.getInviteLink(peer);
                TextComponent component = new TextComponent(TextComponent.fromLegacyText(Lang.LINK.toString()));
                component.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link));
                component.setHoverEvent(new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        Lang.OPEN_CONVERSATION_HOVER.toComponent("{conversation}", Lang.NEW_CONVERSATION.toString()))
                );
                player.sendMessage(
                        ChatBuilder.replace(
                                Lang.CONVERSATION_CREATED.toString(),
                                ArrayUtils.createMap("{link}", new BaseComponent[]{component})
                        )
                );
                ConversationModel model = new ConversationModel(
                        peer,
                        playerModel.getUUID(),
                        Lang.NEW_CONVERSATION.toString(),
                        link);
                model.saveOrUpdate();
            } catch (ClientException | ApiException e) {
                player.sendMessage(e.getLocalizedMessage());
            }
        });
    }
}
