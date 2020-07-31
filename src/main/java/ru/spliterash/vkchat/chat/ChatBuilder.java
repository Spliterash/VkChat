package ru.spliterash.vkchat.chat;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.VkChat;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ComponentBuilder;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;
import ru.spliterash.vkchat.utils.ComponentUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для замены плейсхолдеров на кликабельные компоненты
 */
@UtilityClass
public class ChatBuilder {
    private final Pattern pattern = Pattern.compile("\\{(.*?)}");

    /**
     * Метод для простого создания кликабельных сообщений
     *
     * @param text    Исходный текст с плейсхолдерами
     * @param bindMap Мапа, где ключ это плейсхолдер, а значение то что будет вместо него
     */
    public BaseComponent[] replace(String text, Map<String, BaseComponent[]> bindMap) {
        return compile(text, m -> bindMap.get(m.getText()), pattern);
    }

    /**
     * Собствено можно любую логику сделать
     *
     * @param text    Исходный текст с плейсхолдерами
     * @param onFind  На что заменять при нахождении
     * @param pattern Регулярное выражение для поиска замены
     * @return Массив, содержащий кликабельные сообщения
     */
    public BaseComponent[] compile(String text, Function<MatcherWrapper, BaseComponent[]> onFind, Pattern pattern) {
        ComponentBuilder builder = new ComponentBuilder("");
        Matcher m = pattern.matcher(text);
        m.reset();
        int oldEnd = 0;
        int endIndex = -1;
        // Пока есть плейсхолдеры
        while (m.find()) {
            //Текст до плейсхолдера
            String pre = text.substring(oldEnd, m.start());
            //Сразу же его добавляем/
            builder.append(TextComponent.fromLegacyText(pre), ComponentBuilder.FormatRetention.NONE);
            //Плейсхолдер
            BaseComponent[] components = onFind.apply(new MatcherWrapper(m));
            //Если есть то добавляем
            if (components != null)
                builder.append(components, ComponentBuilder.FormatRetention.ALL);
                //Иначе добавляем его как текст
            else
                builder.append(TextComponent.fromLegacyText(m.group()), ComponentBuilder.FormatRetention.ALL);
            endIndex = m.end();
            oldEnd = m.end();
        }
        //Если ни разу не сработало, то просто возращаем текст
        if (endIndex == -1) {
            builder.append(TextComponent.fromLegacyText(text));
        }
        //Иначе просто добавляем недостающее(если есть)
        else if (endIndex < text.length()) {
            builder.append(TextComponent.fromLegacyText(text.substring(endIndex)), ComponentBuilder.FormatRetention.NONE);
        }
        BaseComponent[] result = builder.create();
        long a = System.currentTimeMillis();
        result = ComponentUtils.removeEmpty(new ArrayList<>(Arrays.asList(result))).toArray(new BaseComponent[0]);
        VkChat.getInstance().getLauncher().getLogger().info("Cleanup time is " + (System.currentTimeMillis() - a));
        return result;
    }
}
