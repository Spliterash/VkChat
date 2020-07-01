package ru.spliterash.vkchat.chat;

import lombok.Getter;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.vkchat.Lang;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.utils.StringUtils;
import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.*;
import java.util.function.Predicate;

@Getter
public class ConversationSetup {
    private static final Set<ConversationSetup> instances = new HashSet<>();
    private final AbstractPlayer player;
    private final String code;

    private ConversationSetup(@NotNull AbstractPlayer player) {
        this.player = Objects.requireNonNull(player);
        this.code = StringUtils.generateRandomDigitString(6);
        VkChat.getInstance().getLauncher().runTaskLater(this::autoDestroy, 20 * 60 * 5);
        sendStartMessage();
    }

    /**
     * Запускает новую настройку беседы
     */
    public static void start(AbstractPlayer player) {
        ConversationSetup setup = getSetup(player);
        if (setup == null) {
            setup = new ConversationSetup(player);
            instances.add(setup);
        } else {
            setup.sendStartMessage();
        }
    }


    public void sendStartMessage() {
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
        player.sendMessage(ChatBuilder.compile(body, components));
    }

    private static ConversationSetup getInstance(Predicate<ConversationSetup> predicate) {
        return instances
                .stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public static ConversationSetup getSetup(AbstractPlayer sender) {
        return getInstance(s -> s.getPlayer().equals(sender));
    }

    public static ConversationSetup getSetup(String code) {
        return getInstance(s -> s.getCode().equals(code));
    }

    private void autoDestroy() {
        player.sendMessage(Lang.SETUP_AUTODESTROY.toComponent());
        destroy();
    }

    public void destroy() {
        instances.remove(this);
    }
}
