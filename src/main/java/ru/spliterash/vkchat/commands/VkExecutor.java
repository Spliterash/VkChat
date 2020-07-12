package ru.spliterash.vkchat.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VkExecutor implements AbstractCommandExecutor {
    @Override
    public List<String> onTabComplete(AbstractSender sender, String... args) {
        if (args.length <= 1) {
            List<String> variants = new ArrayList<>();
            if (sender.hasPermission("vk.setup")) {
                variants.add("setup");
            }
            if (sender.hasPermission("vk.admin")) {
                variants.add("main");
            }
            if (sender.hasPermission("vk.use")) {
                variants.add("link");
                variants.add("unlink");
            }
            return variants;
        } else
            return Collections.emptyList();
    }

    @Override
    public void onCommand(AbstractSender sender, String... args) {
        if (args.length == 0) {
            sendInfo(sender);
            return;
        }
        switch (args[0]) {
            case "link":
                processLink(sender, args);
                break;
            case "unlink":
                processUnLink(sender);
                break;
            case "setup":
                setupPeer(sender);
                break;
            case "createNewConversation":
                createNewConversation(sender);
                break;

        }
    }

    private void createNewConversation(AbstractSender sender) {
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        LinkHelper setup = LinkHelper.getSetup(player);
        if (setup == null) {
            player.sendMessage(Lang.SETUP_NOT_IN_PROGRESS.toComponent());
            return;
        }
        PlayerModel playerModel;
        PlayerDao dao = Database.getDao(PlayerModel.class);
        try {
            playerModel = dao.queryForId(player.getUUID());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
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
                component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.CONVERSATION_OPEN_HOVER.toComponent()));
                player.sendMessage(
                        ChatBuilder.compile(
                                Lang.CONVERSATION_CREATED.toString(),
                                ArrayUtils.createMap("{link}", new BaseComponent[]{component})
                        )
                );
                ConversationModel model = new ConversationModel(
                        peer,
                        playerModel,
                        link);
                model.saveOrUpdate();
            } catch (ClientException | ApiException | SQLException e) {
                player.sendMessage(e.getLocalizedMessage());
            }
        });
    }

    private void setupPeer(AbstractSender sender) {
        if (!sender.hasPermission("vk.setup")) {
            sender.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        PlayerDao dao = Database.getDao(PlayerModel.class);
        try {
            PlayerModel link = dao.queryForId(player.getUUID());
            if (link == null) {
                player.sendMessage(Lang.NOT_LINK.toComponent());
                return;
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        LinkHelper.start(player, LinkHelper.SetupType.CONVERSATION);

    }

    private void processUnLink(AbstractSender sender) {
        if (!sender.hasPermission("vk.use")) {
            sender.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel model;
        try {
            model = dao.queryForId(player.getUUID());
            if (model == null) {
                player.sendMessage(Lang.NOT_LINK.toComponent());
                return;
            }
            dao.delete(model);
            player.sendMessage(Lang.OK.toString());
        } catch (SQLException throwables) {
            player.sendMessage("&cSomething error goes here, check console :(");
            throw new RuntimeException(throwables);
        }
    }

    private void processLink(AbstractSender sender, String... args) {
        if (!sender.hasPermission("vk.use")) {
            sender.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        PlayerDao dao = Database.getDao(PlayerModel.class);
        try {
            PlayerModel link = dao.queryForId(player.getUUID());
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
        } catch (SQLException throwables) {
            player.sendMessage("&cSomething goes wrong, uff :(");
            throw new RuntimeException(throwables);
        }
    }

    private boolean isConsole(AbstractSender sender) {
        if (!(sender instanceof AbstractPlayer)) {
            sender.sendMessage(ChatColor.RED + "Only players");
            return true;
        } else
            return false;
    }

    private void sendInfo(AbstractSender sender) {
        if (!sender.hasPermission("vk.use"))
            sender.sendMessage(Lang.NO_PEX.toComponent());
        else {
            sender.sendMessage(Lang.USER_VK_HELP.toComponent());
            if (sender.hasPermission("vk.admin"))
                sender.sendMessage(Lang.ADMIN_VK_HELP.toComponent());
        }
    }


}
