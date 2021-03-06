package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.md_5_chat.api.ChatColor;
import ru.spliterash.vkchat.md_5_chat.api.chat.BaseComponent;
import ru.spliterash.vkchat.md_5_chat.api.chat.ComponentBuilder;
import ru.spliterash.vkchat.md_5_chat.api.chat.HoverEvent;
import ru.spliterash.vkchat.md_5_chat.api.chat.TextComponent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ComponentUtils {
    public TextComponent getNullComponent() {
        TextComponent component = new TextComponent(ChatColor.RED + "ERROR");
        component.setHoverEvent(
                new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        TextComponent.fromLegacyText(
                                ChatColor.RED + "User not found, sry\nStacktrace here: \n" +
                                        Arrays
                                                .stream(Thread.currentThread().getStackTrace())
                                                .map(s -> s.getClassName() + " in method " + s.getMethodName() + " on line " + s.getLineNumber())
                                                .collect(Collectors.joining("\n"))
                        )
                ));
        return component;
    }

    public BaseComponent[] join(List<String> list, String character) {
        ComponentBuilder hoverBuilder = new ComponentBuilder("");
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            hoverBuilder.append(TextComponent.fromLegacyText(current), ComponentBuilder.FormatRetention.NONE);
            if (i < list.size() - 1) {
                hoverBuilder.append(character);
            }
        }
        return hoverBuilder.create();
    }


    private boolean needToDelete(BaseComponent component) {
        if (component instanceof TextComponent) {
            TextComponent text = (TextComponent) component;
            if (text.getText() != null && !text.getText().isEmpty())
                return false;
        }
        return component.getExtra() == null || component.getExtra().size() == 0;
    }

    public List<BaseComponent> removeEmpty(List<BaseComponent> list) {
        for (int i = 0; i < list.size(); i++) {
            BaseComponent baseComponent = list.get(i);
            if (needToDelete(baseComponent)) {
                list.remove(i);
                i--;
            } else if (baseComponent.getExtra() != null && baseComponent.getExtra().size() > 0) {
                baseComponent.setExtra(removeEmpty(baseComponent.getExtra()));
            }
        }
        return list;
    }
}

