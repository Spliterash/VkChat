package ru.spliterash.vkchat.chat;

import lombok.Getter;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ClickEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.db.DatabaseLoader;
import ru.spliterash.vkchat.db.model.PlayerModel;
import ru.spliterash.vkchat.utils.StringUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;
import ru.spliterash.vkchat.wrappers.AbstractTask;

import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;

@Getter
public class LinkHelper {
    private static final Set<LinkHelper> instances = new HashSet<>();
    private final AbstractPlayer player;
    private final String code;
    private final SetupType type;
    private final AbstractTask destroyTask;

    private LinkHelper(@NotNull AbstractPlayer player, SetupType type) {
        this.player = Objects.requireNonNull(player);
        this.code = StringUtils.generateRandomDigitString(6);
        this.type = type;
        destroyTask = VkChat.getInstance().getLauncher().runTaskLater(this::autoDestroy, 20 * 60 * 5);
        sendStartMessage();
    }

    /**
     * Запускает новую настройку беседы
     */
    public static void start(AbstractPlayer player, SetupType type) {
        LinkHelper setup = getSetup(player);
        if (setup == null) {
            setup = new LinkHelper(player, type);
            instances.add(setup);
        } else {
            setup.sendStartMessage();
        }
    }

    public PlayerModel getPlayerModel() throws SQLException {
        return DatabaseLoader.getBase().getPlayerByUUID(player.getUUID());
    }

    public void sendStartMessage() {
        switch (type) {
            case PROFILE:
                sendLinkMessage();
                break;
            case CONVERSATION:
                sendConversationMessage();
                break;
            default:
                autoDestroy();
                break;
        }
    }

    private void sendLinkMessage() {
        String body = Lang.LINK_START.toString();
        Map<String, BaseComponent[]> components = new HashMap<>();
        // Создание компонента для кода
        {
            String msg = "link " + getCode();
            BaseComponent[] code = new BaseComponent[]{new TextComponent(msg)};
            code[0].setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.VERIFY_CODE_HOVER.toComponent()));
            code[0].setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, msg));
            components.put("{code}", code);
        }
        player.sendMessage(ChatBuilder.replace(body, components));
    }

    private void sendConversationMessage() {
        String body = Lang.SETUP_START.toString();
        Map<String, BaseComponent[]> components = new HashMap<>();
        // Создание компонента для кода
        {
            String msg = "verify " + getCode();
            BaseComponent[] code = new BaseComponent[]{new TextComponent(msg)};
            code[0].setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.VERIFY_CODE_HOVER.toComponent()));
            code[0].setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, msg));
            components.put("{code}", code);
        }
        {
            BaseComponent[] createNew = new BaseComponent[]{new TextComponent(Lang.CREATE_NEW_CONVERSATION.toComponent())};
            createNew[0].setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vk createNewConversation"));
            createNew[0].setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Lang.CREATE_NEW_CONVERSATION_HOVER.toComponent()));
            components.put("{new}", createNew);
        }
        player.sendMessage(ChatBuilder.replace(body, components));
    }

    private static LinkHelper getInstance(Predicate<LinkHelper> predicate) {
        return instances
                .stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public static LinkHelper getSetup(AbstractPlayer sender) {
        return getInstance(s -> s.getPlayer().equals(sender));
    }

    public static LinkHelper getSetup(String code) {
        return getInstance(s -> s.getCode().equals(code));
    }

    private void autoDestroy() {
        player.sendMessage(Lang.SETUP_AUTODESTROY.toComponent());
        destroy();
    }

    public void destroy() {
        destroyTask.cancel();
        instances.remove(this);
    }

    public enum SetupType {
        CONVERSATION, PROFILE
    }
}
