package ru.spliterash.vkchat.wrappers;

import java.io.IOException;
import java.util.List;


public interface AbstractConfig {

    default String getString(String key, String def) {
        java.lang.String result = getString(key);
        if (result != null)
            return result;
        else
            return def;
    }

    default boolean has(String key) {
        return getString(key) != null;
    }

    default String getString(String key) {
        Object obj = get(key);
        if (obj != null)
            return obj.toString();
        else
            return null;
    }

    Object get(String key);

    default List<String> getStringList(String key) {
        Object obj = get(key);
        if (obj instanceof List)
            //noinspection unchecked
            return (List<String>) obj;
        else
            return null;
    }

    default void setString(String key, String value) {
        set(key, value);
    }

    void set(String key, Object value);

    void save() throws IOException;

}
