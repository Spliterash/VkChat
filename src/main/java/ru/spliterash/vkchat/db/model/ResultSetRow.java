package ru.spliterash.vkchat.db.model;

import java.util.HashMap;

public class ResultSetRow extends HashMap<String,Object> {
    public Integer getInt(String key){
        return (Integer) get(key);
    }
    public String getString(String key){
        return get(key).toString();
    }
}
