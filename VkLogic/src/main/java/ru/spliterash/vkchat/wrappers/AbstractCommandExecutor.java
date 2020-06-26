package ru.spliterash.vkchat.wrappers;

import java.util.Collections;
import java.util.List;

public interface AbstractCommandExecutor {
    void onCommand(AbstractSender sender, String... args);

    default List<String> onTabComplete(AbstractSender sender, String... args) {
        return Collections.emptyList();
    }
}
