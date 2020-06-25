package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

import java.util.List;
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
        return ChatColor.stripColor(str);
    }

}
