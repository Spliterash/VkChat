package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ArrayUtils {
    public <T> T[] putAll(T[] components, T[] add, int to) {
        int newSize = components.length + add.length;
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[newSize];
        int k = 0;
        for (int i = 0; i < components.length; i++) {
            if (i == to) {
                for (T t : add) {
                    array[k] = t;
                    k++;
                }
            } else {
                array[k] = components[i];
                k++;
            }

        }
        return array;
    }

    public <K, V> Map<K, V> createMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
