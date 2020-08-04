package ru.spliterash.vkchat.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class SimpleMapBuilder<K, V> {
    @Getter
    private final Map<K, V> map = new HashMap<>();

    public SimpleMapBuilder<K, V> add(K key, V value) {
        map.put(key, value);
        return this;
    }

}
