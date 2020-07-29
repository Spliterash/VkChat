package ru.spliterash.vkchat;


import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ComponentBuilder;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.StringUtils;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings({"ArraysAsListWithZeroOrOneArgument", "SpellCheckingInspection", "unused"})
public enum Lang {
    CONVERSATION_INVITE(
            "User {inviter} invite {invited}",
            "Пользователь {inviter} пригласил {invited}"),
    UNKNOWN(
            "unknown",
            "неизвестно"),
    USER_HOVER(
            Arrays.asList(
                    "&7Gender: &6{gender}",
                    "&7City: &6{city}",
                    "&7Статус: &6{status}",
                    "&7Birthday: &6{birthday}"
            ),
            Arrays.asList(
                    "&7Пол: {gender}",
                    "&7Город: {city}",
                    "&7Статус: {status}",
                    "&7День рождение: {birthday}"
            )
    ),
    USER_FORMAT("{first_name} {last_name}"),
    CONVERSATION_COMPONENT("[VK]"),
    VK_TO_MINECRAFT_CHAT_FORMAT("&7[&9{vk}&7]&a{user}&e: &f{text}"),
    VK_TO_MINECRAFT_INFO_FORMAT("&[&9{vk}&7] &a{message}"),
    MINECRAFT_TO_VK_FORMAT("{user}: {message}"),
    MALE(
            "Male",
            "Мужской"),
    FEMALE(
            "Female",
            "Женский"),
    USER_VK_HELP(
            Arrays.asList(
                    "&b/vk link &6- Link minecraft to vk",
                    "&b/vk unlink &6- Unlink minecraft to vk &c(Delete all conversations)",
                    "&b/vk select &6- Select personal conversaiton to write with &b/vk Any message",
                    "&b/vk &a[message] &6- send message to personal conversation and online players in this conversation",
                    "&b/vk setup &6- Setup or create new private conversation",
                    "&b/vk list &6- List created conversations"
            ),
            Arrays.asList(
                    "&b/vk link &6- Привязать аккаунт майнкрафта к вк",
                    "&b/vk unlink &6- Отвязать аккаунт от вк &c(Удаляет все приваязанные беседы)",
                    "&b/vk select &6- Выбрать приватную беседу для чата",
                    "&b/vk &a[сообщение] &6- Отправить сообщение в приватную беседу и онлайн игрокам в этой беседе",
                    "&b/vk setup &6- Настроить или создать новую приватную беседу",
                    "&b/vk list &6- Посмотреть список созданных своих бесед"
            )
    ),
    ADMIN_VK_HELP(
            Arrays.asList(
                    "&b/vk main &6- Setup MAIN conversation, all messages include"
            ),
            Arrays.asList(
                    "&b/vk main &6- Установить главную беседу, в неё приходят все сообщения"
            )
    ),
    OPEN_URL_HOVER(
            "&6Click me to open a &bvk.com&6 conversation",
            "&6Нажми на меня чтобы открыть беседу &bvk.com"),
    ALREADY_LINK(
            "&6You are already link your account to &a{user}",
            "&6Вы уже привязали свой аккаунт к &a{user}"),
    NOT_LINK(
            "&6For this action your account need be linked, you can link use &b/vk link",
            "&6Ваш аккаунт не привязан, вы можете привязать его с помощью команды &b/vk link"
    ),
    OK("&aOperation completed", "&aОперация выполнена"),
    WRONG_USER("&6User does not exists", "&6Пользователя не существует"),
    SETUP_START(
            "&6To install the conversation, invite the bot to the existing conversation " +
                    "and give it read permissions, and then enter &b{code}&r&a(clickable)&6. " +
                    "If you are too lazy, click &b&n{new}&r&6 and the conversation will be created automatically",
            "&6Для установки беседы пригласите в существующую беседу бота и выдайте " +
                    "ему права на чтение, а после этого введите &b&n{code}&r&a(кликабельно)&6. " +
                    "Если вам лень, нажмите &b&n{new}&r&6 и беседа будет создана автоматически"),
    NO_PEX("&cNo perms, sry", "&cУвы, но у тебя недостаточно прав"),
    VERIFY_CODE_HOVER(
            "&6Click and press CTRL + A, after CTRL + C to copy code",
            "&6Кликните, а затем нажмите CTRL + A, а затем CTRL + C чтобы скопировать код"
    ),
    CREATE_NEW_CONVERSATION_HOVER(
            "&6Click here to create new conversation",
            "&6Нажмите сюда для автоматического создания новой беседы"
    ),
    CREATE_NEW_CONVERSATION("(Create new conversation)", "(Создать новую беседу)"),
    SETUP_NOT_IN_PROGRESS(
            "Conversation setup not in progress, you can run it with &b/vk setup",
            "&6Настройка беседы не была запущена, вы можете запустить её командой &b/vk setup"
    ),
    SETUP_AUTODESTROY(
            "&6Conversation setup will be autoremoved, because you dont setup conversation",
            "&6Установка беседы была отменена поскольку вы ничего не сделали"),
    LINK("[URL]", "[Ссылка]"),
    CONVERSATION_CREATED(
            "&6Conversation created, to open click: &b{link}",
            "&6Беседа успешно создана, чтобы открыть нажмите: &6{link}"),
    CONVERSATION_OPEN_HOVER(
            "&6Press me to open conversation",
            "&6Нажми на меня, чтобы попасть в эту беседу"),
    PLAYER_JOIN(
            "Player {player} join to server",
            "Игрок {player} зашёл на сервер"),
    PLAYER_JOIN_FIRST(
            "Player {player} join to server first time",
            "Игрок {player} зашёл на сервер в первый раз"),
    PLAYER_EXIT(
            "Player {player} exit",
            "Игрок {player} вышел с сервера"),
    NOT_LINK_CONVERSATION(
            "This conversation does not link, please remove bot",
            "Эта беседа не связана с сервером, пожалуйста, выгоните меня, чтобы не нагружать базу"
    ),
    CONSOLE_COMMAND(
            "This command can be input only from console, so none output",
            "Данная команда может быть выполнена только в консоли, поэтому невозможно прислать результат сюда"
    ),
    WRONG_CODE(
            "Wrong verification code",
            "Неправильный код верификации"),
    CONVERSATION_ALREADY_LINK(
            "This conversation already linked by {user}",
            "Эта беседа уже связана {user}"),
    YOU_NOT_INITIALIZE_LINK(
            "It not your code, please go away",
            "Это не твой код верификации"),
    CONVERSATION_LINK_SUCCESS(
            "You link this conversation to your account",
            "Успешно, вы связали эту беседу со своим аккаунтом"),
    CONVERSATION_INVITE_BY_URL(
            "&aUser &b{user}&a join with url",
            "&b{user}&a присоединился к беседе по ссылке"),
    CONVERSATION_KICK(
            "&aUser &b{user_1}&a kick &b{user_2}",
            "&aПользователь &b{user_1}&a кикнул &b{user_2}"),
    LINK_START(
            "&6In order to link your minecraft account with VK, you need to send this code &b({code})&6 to the group messages",
            "&6Для того чтобы связать свой майнкрафт аккаунт с вк, вам необходимо отправить этот код &b&n{code}&r&6 в сообщения группы"),

    VK_LINKED("This vk account already linked to {minecraft}",
            "Этот аккаунт уже привязан на {minecraft}"),
    USER_LINK_SUCCESS(
            "You success link user to minecraft",
            "Вы успешно связали свой аккаунт с майнкрафтом, теперь ваш ник будет видно в сообщениях"
    ),
    NOT_CONVERSATION("It now conversation", "Это не беседа"),
    LINK_FAIL(
            "An error occurred while getting the link. Make sure the bot has admin rights." +
                    "as well as in the conversation settings allowed to receive links",
            "При получении ссылки произошла ошибка. Убедитесь что сообщество имеет права администратора, " +
                    "а так же в настройках беседы разрешено получение ссылок"),
    CONVERSATION_SELECT_TITLE(
            "&6Select conversation before write to private",
            "&6Выбери в какую приватную беседу писать"),
    CONVERSATION_SELECT_BUTTON_TITLE("[SELECT]", "[ВЫБРАТЬ]"),
    CONVERSATION_SELECT_BUTTON_HOVER(
            "&7Click me to select this conversation",
            "&7Нажми на меня, чтобы выбрать эту беседу"),
    CONVERSATION_SELECT_ROW("&9{vk}&7 - &n&a{select}"),
    NO_ANY_CONVERSATION(
            "&6You are does not have any conversation",
            "&6Вы не состоите ни в одной беседе"),
    CONVERSATION_SELECTED(
            "&6You select conversation",
            "&6Вы выбрали беседу"),
    CONVERSATION_LIST_TITLE(
            "&6Created conversation list:",
            "&6Список созданных бесед:"),
    DELETE_TITLE(
            "[DELETE]",
            "[УДАЛИТЬ]"),
    DELETE_CONVERSATION_HOVER(
            "&7Click to unlink this conversation",
            "&7Нажми чтобы отвязать эту беседу"),
    CONVERSATION_LIST_ROW(
            "&9{conversation} &aAction &6- &c{delete}{select_main}",
            "&9{conversation} &aдействия &6- &c{delete}{select_main}"),
    MESSAGE_SEND(
            "&aYour message send to selected conversation &9{conversation}",
            "&aВаше сообщение было отправлено в выбранную вами беседу &9{conversation}"),
    CONVERSATION_SELECT_MAIN_HOVER(
            "&7Click here to select MAIN plugin conversation",
            "&7Нажми чтобы выбрать эту беседу как основную"),
    NOT_OWNER(
            "&6You are not owner on this conversation",
            "&6Вы не владелец беседы"),
    DELETE_CONFIRMATION(
            "&6If you rly want delete &9{conversation}&6 click &c{delete}",
            "&6Для того чтобы удалить &9{conversation}&6 нажмите на &c{delete}");


    /**
     * Оригинальные переводы
     * 0 индекс - англиский
     * 1 индекс - русский
     */
    private final Object[] original = new Object[2];
    private Object selected;

    /**
     * Конструктор для простых строк
     *
     * @param en На англиском
     * @param ru На русском
     */
    Lang(String en, String ru) {
        original[0] = en;
        original[1] = ru;
    }

    /**
     * Конструктор для многострочных переводов
     *
     * @param en На англиском
     * @param ru На русском
     */
    Lang(List<String> en, List<String> ru) {
        original[0] = en;
        original[1] = ru;
    }

    Lang(List<String> en) {
        this(en, en);
    }

    Lang(String en) {
        this(en, en);
    }

    public static void reload(File folder, String lang) {
        File langFile = new File(folder, lang + ".yml");
        int index;
        if (lang.equals("ru"))
            index = 1;
        else
            index = 0;
        fill(langFile, index);
    }

    private static void fill(File langFile, int index) {
        AbstractConfig conf = VkChat.getInstance().getLauncher().wrapConfig(langFile);
        boolean saveNeed = false;
        for (Lang value : values()) {
            Object obj = conf.get(value.name());
            if (obj == null) {
                obj = value.original[index];
                conf.set(value.name(), obj);
                saveNeed = true;
            }
            if (obj instanceof String) {
                value.selected = StringUtils.t(obj.toString());
            } else {
                //noinspection unchecked
                List<String> list = (List<String>) obj;
                value.selected = StringUtils.t(list);
            }
        }
        if (saveNeed) {
            try {
                conf.save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        if (isString()) {
            return selected.toString();
        } else {
            //noinspection unchecked
            List<String> list = (List<String>) selected;
            return String.join("\n", list);
        }
    }

    private boolean isString() {
        return selected instanceof String;
    }

    public List<String> toList(String... replace) {
        if (isString()) {
            return Collections.singletonList(StringUtils.replace(selected.toString(), replace));
        } else if (replace.length > 0) {
            //noinspection unchecked
            return ((List<String>) selected)
                    .stream()
                    .map(s -> StringUtils.replace(s, replace))
                    .collect(Collectors.toList());
        } else
            //noinspection unchecked
            return new ArrayList<>(((List<String>) selected));
    }

    public BaseComponent[] toComponent(String... replace) {
        if (isString())
            return TextComponent.fromLegacyText(toString(replace));
        else {
            ComponentBuilder builder = new ComponentBuilder("");
            //noinspection unchecked
            List<String> source = (List<String>) selected;
            for (String s : source) {
                builder.append(TextComponent.fromLegacyText(StringUtils.replace(s, replace)));
                builder.append("\n", ComponentBuilder.FormatRetention.NONE);
            }
            return builder.create();
        }
    }

    public String toString(String... replace) {
        return StringUtils.replace(toString(), replace);
    }

    public String[] toArray() {
        return toList().toArray(new String[0]);
    }

    public String toPlainText(String... replace) {
        return ChatColor.stripColor(toString(replace));
    }
}
