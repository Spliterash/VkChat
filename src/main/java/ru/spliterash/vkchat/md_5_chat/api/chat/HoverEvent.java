package ru.spliterash.vkchat.md_5_chat.api.chat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public final class HoverEvent
{

    private final Action action;
    private final BaseComponent[] value;

    public enum Action
    {

        SHOW_TEXT,
        SHOW_ACHIEVEMENT,
        SHOW_ITEM,
        SHOW_ENTITY
    }
}
