package ru.spliterash.vkchat;


import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TODO Написать этот класс
public enum Lang {
    CONVERSATION_JOIN("User {inviter} invite {invited}", "Пользователь {inviter} пригласил {invited}"),
    USER_TEXT("&a{first_name} {last_name}"),
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
    MALE("Male", "Мужской"),
    FEMALE("Female", "Женский");


    /**
     * Оригинальные переводы
     * 0 индекс - англиский
     * 1 индекс - русский
     */
    private final Object[] original = new Object[2];
    private final boolean isString;
    private Object selected;

    /**
     * Конструктор для простых строк
     *
     * @param en На англиском
     * @param ru На русском
     */
    Lang(String en, String ru) {
        isString = true;
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
        isString = false;
        original[0] = en;
        original[1] = ru;
    }

    Lang(List<String> en) {
        this(en, en);
    }

    Lang(String en) {
        this(en, en);
    }

    @Override
    public String toString() {
        if (isString) {
            return selected.toString();
        } else {
            //noinspection unchecked
            List<String> list = (List<String>) selected;
            return String.join("\n", list);
        }
    }

    public List<String> toList() {
        if (isString) {
            return Collections.singletonList(selected.toString());
        } else {
            //noinspection unchecked
            return (List<String>) selected;
        }
    }

    public BaseComponent[] toComponent() {
        if (isString)
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
