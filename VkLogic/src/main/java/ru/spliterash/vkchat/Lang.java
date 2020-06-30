package ru.spliterash.vkchat;


import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.StringUtils;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public enum Lang {
    CONVERSATION_INVITE("User {inviter} invite {invited}", "Пользователь {inviter} пригласил {invited}"),
    UNKNOWN("unknown", "неизвестно"),
    USER_HOVER(
            Arrays.asList(
                    "Gender: {gender}",
                    "City: {city}",
                    "Статус: {status}",
                    "Birthday: {birthday}"
            ),
            Arrays.asList(
                    "Пол: {gender}",
                    "Город: {city}",
                    "Статус: {status}",
                    "День рождение: {birthday}"
            )
    ),
    USER_FORMAT("{first_name} {last_name}"),
    PEER_COMPONENT("[VK]"),
    VK_TO_MINECRAFT("&9{vk}&a{user}&e:&f{text}"),
    MALE("Male", "Мужской"),
    FEMALE("Female", "Женский"),
    USER_VK_HELP(
            Arrays.asList(
                    "&b/vk link [domain] &6- Link minecraft to vk",
                    "&b/vk [message] &6- send message to personal conversation and online players in this conversation",
                    "&b/vk setup &6- Setup or create new private conversation"
            ),
            Arrays.asList(
                    "&bvk link [domain] &6- Привязать аккаунт майнкрафта к вк",
                    "&bvk [сообщение] &6- Отправить сообщение в приватную беседу и онлайн игрокам в этой беседе",
                    "&bvk setup &6- Настроить или создать новую приватную беседу"
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
    OPEN_URL_HOVER("&6Click me to open a &bvk.com&6 conversation", "&6Нажми на меня чтобы открыть беседу &bvk.com"),
    ALREADY_LINK("&6You are already link your account to {user}", "&6Вы уже привязали свой аккаунт к {user}"),
    NOT_LINK(
            "&6For this action your account need be linked, you can link use &b/vk link [domain]",
            "&6Ваш аккаунт не привязан, вы можете привязать его с помощью команды &b/vk link [domain]&6, где &bdomain&6 это ваш домен"
    ),
    OK("&aOperation completed", "&aОперация выполнена"),
    WRONG_USER("&6User does not exists", "&6Пользователя не существует"),
    SETUP_START("&6The conversation setup is started, please write down any message in the conversation where there is a bot and it has read rights",
            "&6Настройка беседы начата, пожалуйста запишите любое сообщение в беседу где есть бот и ему выданы права чтения"),
    NO_PEX("&cNo perms, sry", "&cУвы, но у тебя недостаточно прав");


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

    public List<String> toList() {
        if (isString()) {
            return Collections.singletonList(selected.toString());
        } else {
            //noinspection unchecked
            return (List<String>) selected;
        }
    }

    public BaseComponent[] toComponent() {
        if (isString())
            return TextComponent.fromLegacyText(toString());
        else {
            ComponentBuilder builder = new ComponentBuilder("");
            //noinspection unchecked
            List<String> source = (List<String>) selected;
            for (String s : source) {
                builder.append(TextComponent.fromLegacyText(s));
                builder.append("\n", ComponentBuilder.FormatRetention.NONE);
            }
            return builder.create();
        }
    }

    public String[] toArray() {
        return toList().toArray(new String[0]);
    }
}
