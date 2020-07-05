package ru.spliterash.vkchat.chat;

import com.vk.api.sdk.callback.longpoll.CallbackApiLongPoll;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ComponentBuilder;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для динамической замены плейсхолдеров на кликабельные компоненты
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
    public BaseComponent[] compile(String text, Map<String, BaseComponent[]> bindMap) {
        ComponentBuilder builder = new ComponentBuilder("");
        Matcher m = pattern.matcher(text);
        m.reset();
        int oldEnd = 0;
        int endIndex = -1;
        // Пока есть плейсхолдеры
        while (m.find()) {
            //Текст до плейсхолдера
            String pre = text.substring(oldEnd, m.start());
            //Сразу же его добавляем
            builder.append(TextComponent.fromLegacyText(pre), ComponentBuilder.FormatRetention.FORMATTING);
            //Плейсхолдер
            String placeholder = m.group();
            BaseComponent[] components = bindMap.get(placeholder);
            //Если есть то добавляем
            if (components != null)
                builder.append(components, ComponentBuilder.FormatRetention.FORMATTING);
                //Иначе добавляем его как текст
            else
                builder.append(TextComponent.fromLegacyText(placeholder), ComponentBuilder.FormatRetention.FORMATTING);
            endIndex = m.end();
            oldEnd = m.end();
        }
        //Если ни разу не сработало, то просто возращаем текст
        if (endIndex == -1) {
            builder.append(TextComponent.fromLegacyText(text));
        }
        //Иначе просто добавляем недостающее(если есть)
        else if (endIndex < text.length()) {
            builder.append(TextComponent.fromLegacyText(text.substring(endIndex)));
        }
        return builder.create();
    }

    public void main(String[] args) throws ClientException, ApiException {
        VkApiClient client = new VkApiClient(HttpTransportClient.getInstance());
        GroupActor actor = new GroupActor(178913071, "dec2e636cf2c22c757377b7c7e7c8ff11bed525a1fdad0fc12f1b808cb3c2430a5776d3e6518288f6d00d");
        CallbackApiLongPoll longPoll = new CallbackApiLongPoll(client, actor) {
            @Override
            public void messageNew(Integer groupId, Message message) {
                System.out.println(message.toPrettyString());
            }
        };
        longPoll.run();
    }
}
