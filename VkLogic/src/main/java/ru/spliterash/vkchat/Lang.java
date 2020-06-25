package ru.spliterash.vkchat;

import java.util.HashMap;
import java.util.Map;

public enum Lang {
    CONVERSATION_JOIN("User {inviter} invite {invited}", "Пользователь {inviter} пригласил {invited}");
    private Map<String, String> variants = new HashMap<>(2);

    Lang(String en, String ru) {

    }
}
