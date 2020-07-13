package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ArrayUtils {
    public <T> T[] putAll(Class<T> clazz, T[] a1, T[] a2, int to) {
        int newSize = a1.length + a2.length;
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, newSize);
        int k = 0;
        for (int i = 0; i < a1.length; i++) {
            if (i == to) {
                for (T t : a2) {
                    array[k] = t;
                    k++;
                }
            }
            array[k] = a1[i];
            k++;
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
