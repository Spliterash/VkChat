package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@UtilityClass
public class StringUtils {
    public List<String> t(List<String> list) {
        return list
                .stream()
                .map(StringUtils::t)
                .collect(Collectors.toList());
    }

    public String t(String str) {
        return ChatColor.translateAlternateColorCodes('&',str);
    }

    private final String AB = "0123456789";

    public String generateRandomDigitString(int length) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String ComponentToJson(BaseComponent... components) {
        return ComponentSerializer.toString(components);
    }

    public String replace(String source, String... replace) {
        if (replace.length > 0) {
            if (replace.length % 2 != 0)
                throw new RuntimeException("Oooooooooops");
            String str = source;
            for (int i = 1; i < replace.length; i = i + 2) {
                if (i % 2 == 1)
                    str = str.replace(replace[i - 1], replace[i]);
            }
            return str;
        } else {
            return source;
        }

    }

    public boolean isNotEmpty(String value) {
        return value != null && value.isEmpty();
    }
}
