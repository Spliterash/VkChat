package ru.spliterash.vkchat;


import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import ru.spliterash.vkchat.wrappers.AbstractConfig;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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
    USER_VK_HELP(Arrays.asList(
            "&b/vk link &6- Link minecraft to vk",
            "&b"
    )),
    OPEN_URL_HOVER("&6Click me to open a &bvk.com&6 conversation", "&6Нажми на меня чтобы открыть беседу &bvk.com"),
    ALREADY_LINK("&6You are already link your account to {user}", "&6Вы уже привязали свой аккаунт к {user}"),
    NOT_LINK(
            "&6For this action your account need be linked, you can link use &b/vk link [domain]",
            "&6Ваш аккаунт не привязан, вы можете привязать его с помощью команды &b/vk link [domain]&6, где &bdomain&6 это ваш домен"
    ),
    OK("&aOperation completed", "&aОперация выполнена"),
    WRONG_USER("&6User does not exists", "&6Пользователя не существует");


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
            value.selected = obj;
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
        return original[0] instanceof String;
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
            }
            return builder.create();
        }
    }

    public String[] toArray() {
        return toList().toArray(new String[0]);
    }
}
