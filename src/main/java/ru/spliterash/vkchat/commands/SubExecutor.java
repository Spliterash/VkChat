package ru.spliterash.vkchat.commands;

import ru.spliterash.vkchat.wrappers.AbstractPlayer;

import java.util.Collections;
import java.util.List;

public interface SubExecutor {
    void onCommand(AbstractPlayer player, String[] args);

    default List<String> onTabComplete(String[] args) {
        return Collections.emptyList();
    }
}
