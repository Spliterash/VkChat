package ru.spliterash.vkchat.commands.subs;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.commands.SubExecutor;
import ru.spliterash.vkchat.commands.VkExecutor;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.SimpleMapBuilder;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.List;

public class ListExecutor implements SubExecutor {
    private final VkExecutor parent;

    public ListExecutor(VkExecutor parent) {
        this.parent = parent;
    }

    @Override
    public void onCommand(AbstractPlayer player, String[] args) {
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel link = base.getPlayerByUUID(player.getUUID());
        if (link == null) {
            player.sendMessage(Lang.NOT_LINK.toString());
            return;
        }
        if (args.length == 2) {
            switch (args[0]) {
                case "preDeleteConversation":
                    onPreDeleteConversation(player, args[1]);
                    break;
                case "deleteConversation":
                    onDeleteConversation(player, args[1]);
                    break;
                case "preSelectMainConversation":
                    onPreSelectMainConversation(player, args[1]);
                    break;
                case "selectMainConversation":
                    onSelectMainConversation(player, args[1]);
            }
        } else {
            sendList(player, base);
        }
    }

    private void onSelectMainConversation(AbstractPlayer player, String arg) {
        ConversationModel conversation = checkConversation(player, arg);
        if (conversation == null)
            return;
        VkChat.getInstance().getLauncher().runTaskAsync(() -> {
            try {
                VkChat.getInstance().setGlobalPeer(conversation.getId());
                player.sendMessage(Lang.OK.toComponent());
            } catch (Exception ex) {
                ex.printStackTrace();
                player.sendMessage(ex.getLocalizedMessage());
            }

        });
    }

    private void onPreSelectMainConversation(AbstractPlayer player, String arg) {
        ConversationModel conversation = checkConversation(player, arg);
        if (conversation == null)
            return;
        TextComponent select = new TextComponent(Lang.CONVERSATION_SELECT_BUTTON_TITLE.toComponent());
        select.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk list selectMainConversation " + arg));
        BaseComponent[] conversationComponent = new BaseComponent[]{VkUtils.getInviteLink(conversation)};
        player.sendMessage(ChatBuilder.compile(
                Lang.SELECT_MAIN_CONFIRMATION.toString(),
                new SimpleMapBuilder<String, BaseComponent[]>()
                        .add("{select}", new BaseComponent[]{select})
                        .add("{conversation}", conversationComponent)
                        .getMap()
        ));
    }

    private void sendList(AbstractPlayer player, AbstractBase base) {
        List<ConversationModel> list = base.getPlayerAdminConversation(player.getUUID());
        if (list.size() > 0) {
            player.sendMessage(Lang.CONVERSATION_LIST_TITLE.toComponent());
            for (ConversationModel model : list) {
                BaseComponent[] peer = new BaseComponent[]{VkUtils.getInviteLink(model)};
                TextComponent delete = new TextComponent(Lang.DELETE_TITLE.toComponent());
                delete.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk list preDeleteConversation " + model.getId()));
                delete.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.DELETE_CONVERSATION_HOVER.toComponent()));
                BaseComponent[] selectComponent = new BaseComponent[1];
                if (player.hasPermission("vk.admin")) {
                    selectComponent[0] = new TextComponent(Lang.CONVERSATION_SELECT_BUTTON_TITLE.toComponent());
                    selectComponent[0].setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk list preSelectMainConversation " + model.getId()));
                    selectComponent[0].setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.CONVERSATION_SELECT_MAIN_HOVER.toComponent()));
                } else {
                    selectComponent[0] = new TextComponent();
                }
                player.sendMessage(ChatBuilder.compile(
                        Lang.CONVERSATION_LIST_ROW.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{conversation}", peer)
                                .add("{delete}", new BaseComponent[]{delete})
                                .add("{select_main}", selectComponent)
                                .getMap()
                ));
            }
        } else {
            player.sendMessage(Lang.NO_ANY_CONVERSATION.toComponent());
        }
    }

    private ConversationModel checkConversation(AbstractPlayer player, String arg) {
        int conversationId = parse(player, arg);
        if (conversationId == -1)
            return null;
        ConversationModel conversation = DatabaseLoader.getBase().getConversationById(conversationId);
        if (conversation == null) {
            player.sendMessage(ChatColor.RED + "Bruh");
            return null;
        }
        return conversation;
    }

    private void onPreDeleteConversation(AbstractPlayer player, String arg) {
        ConversationModel conversation = checkConversation(player, arg);
        if (conversation == null)
            return;
        TextComponent delete = new TextComponent(Lang.DELETE_TITLE.toComponent());
        delete.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk list deleteConversation " + arg));
        BaseComponent[] conversationComponent = new BaseComponent[]{VkUtils.getInviteLink(conversation)};
        player.sendMessage(ChatBuilder.compile(
                Lang.DELETE_CONFIRMATION.toString(),
                new SimpleMapBuilder<String, BaseComponent[]>()
                        .add("{delete}", new BaseComponent[]{delete})
                        .add("{conversation}", conversationComponent)
                        .getMap()
        ));
    }

    private void onDeleteConversation(AbstractPlayer player, String arg) {
        int conversationId = parse(player, arg);
        if (conversationId == -1)
            return;
        ConversationModel model = DatabaseLoader.getBase().getConversationById(conversationId);
        PlayerModel owner = model.getOwnerModel();
        if (owner.getUUID().equals(player.getUUID())) {
            model.delete();
            player.sendMessage(Lang.OK.toComponent());
        } else {
            player.sendMessage(Lang.NOT_OWNER.toComponent());
        }
    }

    private int parse(AbstractPlayer player, String arg) {
        try {
            return Integer.parseInt(arg);
        } catch (Exception ex) {
            player.sendMessage(ChatColor.RED + "-_- >_<");
            return -1;
        }
    }
}
