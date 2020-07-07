package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;
import ru.spliterash.vkchat.db.model.PlayerModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public int[] mergeTwoIntCollections(Collection<Integer> a1, Collection<Integer> a2) {
        int[] array = new int[a1.size() + a2.size()];
        int k = 0;
        for (int t : a1) {
            array[k++] = t;
        }
        for (int t : a2) {
            array[k++] = t;
        }
        return array;
    }
}
