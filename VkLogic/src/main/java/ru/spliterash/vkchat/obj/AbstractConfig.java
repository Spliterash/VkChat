package ru.spliterash.vkchat.obj;

import java.io.IOException;


public abstract class AbstractConfig {

    public String get(String key, java.lang.String def) {
        java.lang.String result = get(key);
        if (result != null)
            return result;
        else
            return def;
    }

    public boolean has(String key) {
        return get(key) != null;
    }

    public abstract String get(String key);

    public abstract void set(String key,String value);

    public abstract void save() throws IOException;

}
