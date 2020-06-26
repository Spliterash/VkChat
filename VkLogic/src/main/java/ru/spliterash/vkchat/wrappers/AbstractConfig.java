package ru.spliterash.vkchat.wrappers;

import java.io.IOException;


public interface AbstractConfig {

    default String get(String key, java.lang.String def) {
        java.lang.String result = get(key);
        if (result != null)
            return result;
        else
            return def;
    }

    default boolean has(String key) {
        return get(key) != null;
    }

    String get(String key);

    void set(String key, String value);

    void save() throws IOException;

}
