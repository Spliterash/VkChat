package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.chat.ComponentSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@UtilityClass
public class StringUtils {
    private final String AB = "0123456789";

    public List<String> t(List<String> list) {
        return list
                .stream()
                .map(StringUtils::t)
                .collect(Collectors.toList());
    }

    public String t(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

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

    public boolean isBlankString(String string) {
        return string == null || string.trim().isEmpty();
    }

    public boolean isNotEmpty(String value) {
        return !isBlankString(value);
    }

    public String getString(InputStream stream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            while (true) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return out.toString();
        }
    }

    public String getFirstWord(String text) {


        int index = text.indexOf(' ');

        if (index > -1) { // Check if there is more than one word.

            return text.substring(0, index).trim(); // Extract first word.

        } else {

            return text; // Text is the first word itself.
        }

    }
}
