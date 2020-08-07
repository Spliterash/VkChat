package ru.spliterash.vkchat.commands;

import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.commands.subs.*;
import ru.spliterash.vkchat.db.AbstractBase;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.objects.SimpleMapBuilder;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.util.*;

public class VkExecutor implements AbstractCommandExecutor {
    private final Map<String, SubExecutor> executors = new HashMap<>();

    public VkExecutor() {
        executors.put("list", new ListExecutor(this));
        executors.put("createNewConversation", new CreateNewConversationExecutor(this));
        executors.put("select", new SelectExecutor(this));
        executors.put("link", new LinkExecutor(this));
        executors.put("unlink", new UnLinkExecutor(this));
        executors.put("setup", new SetupExecutor(this));
    }

    @Override
    public void onCommand(AbstractSender sender, String... args) {
        if (!sender.hasPermission("vk.use")) {
            sender.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        if (args.length == 0) {
            sendInfo(sender);
            return;
        }
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        try {
            SubExecutor executor = getExecutor(args);
            if (executor != null) {
                executor.onCommand(player, ArrayUtils.removeFirst(String.class, args));
            } else {
                sendMessage(player, args);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            sender.sendMessage(ChatColor.RED + "Something goes wrong, check console");
        }
    }

    public void sendPlayerConversationList(AbstractPlayer player, List<ConversationModel> playerConversations) {
        player.sendMessage(Lang.CONVERSATION_SELECT_TITLE.toComponent());
        ConversationModel global = VkChat.getInstance().getGlobalConversation();
        int id = global != null ? global.getId() : -1;
        for (ConversationModel conversationModel : playerConversations) {
            if (conversationModel.getId() == id)
                continue;
            String body = Lang.CONVERSATION_SELECT_ROW.toString();
            BaseComponent[] vkComponent = new BaseComponent[]{VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle())};
            TextComponent selectComponent = new TextComponent(Lang.CONVERSATION_SELECT_BUTTON_TITLE.toComponent());
            selectComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.CONVERSATION_SELECT_BUTTON_HOVER.toComponent()));
            selectComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk select " + conversationModel.getId()));
            player.sendMessage(ChatBuilder.replace(
                    body,
                    new SimpleMapBuilder<String, BaseComponent[]>()
                            .add("{vk}", vkComponent)
                            .add("{select}", new BaseComponent[]{selectComponent})
                            .getMap()

            ));
        }
    }

    private void sendMessage(AbstractPlayer player, String[] args) {
        AbstractBase base = DatabaseLoader.getBase();
        PlayerModel link = base.getPlayerByUUID(player.getUUID());
        if (link == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        ConversationModel selected = link.getSelectedConversationModel();
        if (selected == null) {
            sendPlayerConversationList(player);
            return;
        }
        String msg = String.join(" ", args);
        VkChat.getInstance().sendMessage(selected.getId(), VkUtils.prepareMessage(player, msg));
        player.sendMessage(
                ChatBuilder.replace(Lang.MESSAGE_SEND.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{conversation}", new BaseComponent[]{VkUtils.getInviteLink(selected)})
                                .getMap()));


    }

    private void sendPlayerConversationList(AbstractPlayer player) {
        List<ConversationModel> list = DatabaseLoader.getBase().getPlayerMemberConversation(player.getUUID());
        if (list.size() == 0) {
            player.sendMessage(Lang.NO_ANY_CONVERSATION.toComponent());
            return;
        }
        sendPlayerConversationList(player, list);
    }

    private SubExecutor getExecutor(String[] args) {
        if (args.length == 0)
            return null;
        return this
                .executors
                .entrySet()
                .stream()
                .filter(e -> e.getKey().toLowerCase().equals(args[0].toLowerCase()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private boolean isConsole(AbstractSender sender) {
        if (!(sender instanceof AbstractPlayer)) {
            sender.sendMessage(ChatColor.RED + "Only players");
            return true;
        } else
            return false;
    }

    private void sendInfo(AbstractSender sender) {
        sender.sendMessage(Lang.USER_VK_HELP.toComponent());
        if (sender.hasPermission("vk.admin"))
            sender.sendMessage(Lang.ADMIN_VK_HELP.toComponent());
    }

    @Override
    public List<String> onTabComplete(AbstractSender sender, String... args) {
        if (!(sender instanceof AbstractPlayer)) {
            return Collections.emptyList();
        }
        AbstractPlayer player = (AbstractPlayer) sender;

        AbstractBase base = DatabaseLoader.getBase();
        if (args.length <= 1) {
            List<String> variants = new ArrayList<>();
            if (sender.hasPermission("vk.use")) {
                PlayerModel link = base.getPlayerByUUID(player.getUUID());
                if (link == null) {
                    variants.add("link");
                } else {
                    variants.add("unlink");
                    if (sender.hasPermission("vk.setup")) {
                        variants.add("setup");
                        variants.add("list");
                    }
                }
            }
            return variants;
        } else if (args.length <= 2) {
            SubExecutor executor = getExecutor(args);
            if (executor != null)
                return executor.onTabComplete(ArrayUtils.removeFirst(String.class, args));
            else
                return Collections.emptyList();
        } else
            return Collections.emptyList();
    }

}
