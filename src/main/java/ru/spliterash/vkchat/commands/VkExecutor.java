package ru.spliterash.vkchat.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.SneakyThrows;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.chat.LinkHelper;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.ConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerConversationDao;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.ConversationModel;
import ru.spliterash.vkchat.db.model.PlayerConversationModel;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.*;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.SimpleMapBuilder;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VkExecutor implements AbstractCommandExecutor {


    @SneakyThrows
    @Override
    public List<String> onTabComplete(AbstractSender sender, String... args) {
        if (!(sender instanceof AbstractPlayer)) {
            return Collections.emptyList();
        }
        AbstractPlayer player = (AbstractPlayer) sender;
        List<String> variants = new ArrayList<>();
        if (args.length <= 1) {
            if (sender.hasPermission("vk.use")) {
                PlayerDao pDao = Database.getDao(PlayerModel.class);
                PlayerModel link = pDao.queryForId(player.getUUID());
                if (link == null) {
                    variants.add("link");
                } else {
                    variants.add("unlink");
                    variants.add("list");
                    if (sender.hasPermission("vk.setup")) {
                        variants.add("setup");
                    }
                    if (sender.hasPermission("vk.admin")) {
                        variants.add("main");
                    }
                }
            }
        } else if (args.length <= 2) {
            //noinspection SwitchStatementWithTooFewBranches
            switch (args[0]) {
                case "list":
                    variants.add("all");
                    variants.add("owner");
                    break;
            }
        }
        return variants;
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
            switch (args[0]) {
                case "link":
                    processLink(player);
                    break;
                case "unlink":
                    processUnLink(player);
                    break;
                case "setup":
                    setupConversation(player);
                    break;
                case "select":
                    selectConversation(player, args);
                    break;
                case "createNewConversation":
                    createNewConversation(player);
                    break;
                case "list":
                    listConversations(player, args);
                    break;
                default:
                    sendMessage(player, args);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
            sender.sendMessage(ChatColor.RED + "Something goes wrong, check console");
        }
    }

    private void listConversations(AbstractPlayer player, String[] args) {

    }

    private void selectConversation(AbstractPlayer player, String[] args) throws SQLException {
        PlayerConversationDao pc = Database.getDao(PlayerConversationModel.class);
        PlayerDao pDao = Database.getDao(PlayerModel.class);
        PlayerModel pLink = pDao.queryForId(player.getUUID());
        if (pLink == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        List<ConversationModel> playerConversations = pc.queryForPlayer(pLink);
        if (playerConversations.size() == 0) {
            player.sendMessage(Lang.NO_ANY_CONVERSATION.toComponent());
            return;
        }
        //Если челик хочет посмотреть лист
        if (args.length == 1) {
            sendPlayerConversationList(player, playerConversations);
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
            pLink.setSelectedConversation(selected);
            pDao.update(pLink);
            player.sendMessage(Lang.CONVERSATION_SELECTED.toString());
        }
    }

    private void sendPlayerConversationList(AbstractPlayer player, List<ConversationModel> playerConversations) {
        player.sendMessage(Lang.CONVERSATION_SELECT_TITLE.toComponent());
        for (ConversationModel conversationModel : playerConversations) {
            String body = Lang.CONVERSATION_SELECT_ROW.toString();
            BaseComponent[] vkComponent = VkUtils.getInviteLink(conversationModel.getInviteLink(), conversationModel.getTitle());
            TextComponent selectComponent = new TextComponent(Lang.CONVERSATION_SELECT_BUTTON_TITLE.toComponent());
            selectComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.CONVERSATION_SELECT_BUTTON_HOVER.toComponent()));
            selectComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk select " + conversationModel.getId()));
            player.sendMessage(ChatBuilder.compile(
                    body,
                    new SimpleMapBuilder<String, BaseComponent[]>()
                            .add("{vk}", vkComponent)
                            .add("{select}", new BaseComponent[]{selectComponent})
                            .getMap()

            ));
        }
    }

    private void sendMessage(AbstractPlayer player, String[] args) throws SQLException {
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel link = dao.queryForId(player.getUUID());
        if (link == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        ConversationModel selected = link.getSelectedConversation();
        if (selected == null) {
            sendPlayerConversationList(player, link);
            return;
        }
        String msg = String.join(" ", args);
        VkChat.getInstance().sendMessage(selected.getId(), VkUtils.prepareMessage(player, msg));
        player.sendMessage(
                ChatBuilder.compile(Lang.MESSAGE_SEND.toString(),
                        new SimpleMapBuilder<String, BaseComponent[]>()
                                .add("{conversation}", VkUtils.getInviteLink(selected))
                                .getMap()));
    }

    private void sendPlayerConversationList(AbstractPlayer player, PlayerModel model) throws SQLException {
        PlayerConversationDao dao = Database.getDao(PlayerConversationModel.class);
        List<ConversationModel> list = dao.queryForPlayer(model);
        sendPlayerConversationList(player, list);
    }

    private void createNewConversation(AbstractPlayer player) throws SQLException {
        LinkHelper setup = LinkHelper.getSetup(player);
        if (setup == null) {
            player.sendMessage(Lang.SETUP_NOT_IN_PROGRESS.toComponent());
            return;
        }
        PlayerModel playerModel;
        PlayerDao dao = Database.getDao(PlayerModel.class);

        playerModel = dao.queryForId(player.getUUID());
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

    private void setupConversation(AbstractPlayer player) throws SQLException {
        if (!player.hasPermission("vk.setup")) {
            player.sendMessage(Lang.NO_PEX.toComponent());
            return;
        }
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel link = dao.queryForId(player.getUUID());
        if (link == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        LinkHelper.start(player, LinkHelper.SetupType.CONVERSATION);

    }

    private void processUnLink(AbstractPlayer player) throws SQLException {
        PlayerDao dao = Database.getDao(PlayerModel.class);
        PlayerModel model;

        model = dao.queryForId(player.getUUID());
        if (model == null) {
            player.sendMessage(Lang.NOT_LINK.toComponent());
            return;
        }
        dao.delete(model);
        player.sendMessage(Lang.OK.toString());
    }

    private void processLink(AbstractPlayer player) {
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
        sender.sendMessage(Lang.USER_VK_HELP.toComponent());
        if (sender.hasPermission("vk.admin"))
            sender.sendMessage(Lang.ADMIN_VK_HELP.toComponent());
    }


}
