package ru.spliterash.vkchat.chat;

import java.util.regex.Matcher;

public class MatcherWrapper {
    private final Matcher matcher;

    public MatcherWrapper(Matcher matcher) {
        this.matcher = matcher;
    }

    public String getText() {
        return group(0);
    }

    public String group(int i) {
        return matcher.group(i);
    }

    public String group(String name) {
        return matcher.group(name);
    }
}
