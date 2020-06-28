package ru.spliterash.vkchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import ru.spliterash.vkchat.chat.ChatBuilder;
import ru.spliterash.vkchat.db.Database;
import ru.spliterash.vkchat.db.dao.PlayerDao;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.ArrayUtils;
import ru.spliterash.vkchat.utils.VkUtils;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.sql.SQLException;

public class VkExecutor implements AbstractCommandExecutor {
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

        }
    }

    private void processUnLink(AbstractSender sender) {
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        PlayerDao dao = Database.getInstance().getDao(PlayerModel.class);
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
        if (isConsole(sender))
            return;
        AbstractPlayer player = (AbstractPlayer) sender;
        PlayerDao dao = Database.getInstance().getDao(PlayerModel.class);
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
            } else if (args.length == 2) {
                VkChat.getInstance().userAction(args[1], u -> {
                    if (u == null) {
                        player.sendMessage(Lang.WRONG_USER.toString());
                        return;
                    }
                    PlayerModel newLink = new PlayerModel();
                    newLink.setUuid(player.getUUID());
                    newLink.setNickname(player.getName());
                    newLink.setVk(u.getId());
                    try {
                        Database.getInstance().getDao(PlayerModel.class).create(newLink);
                    } catch (SQLException throwables) {
                        player.sendMessage(ChatColor.RED + "OOOOOPS, Another server exception :(");
                        throw new RuntimeException(throwables);
                    }
                });
            } else
                sendInfo(player);
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
    }


}
