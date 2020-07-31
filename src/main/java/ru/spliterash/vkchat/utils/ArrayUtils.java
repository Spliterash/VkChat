package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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

    public <T> T[] removeFirst(Class<T> clazz, T[] source) {
        if (source.length == 0)
            return source;
        //noinspection unchecked
        T[] result = (T[]) Array.newInstance(clazz, source.length - 1);
        System.arraycopy(source, 1, result, 0, source.length - 1);
        return result;
    }

    public <T> T[] mergeTwoIntCollections(Class<T> clazz, Collection<T> a1, Collection<T> a2) {
        //noinspection unchecked
        T[] array = (T[]) Array.newInstance(clazz, a1.size() + a2.size());
        int k = 0;
        for (T t : a1) {
            array[k++] = t;
        }
        for (T t : a2) {
            array[k++] = t;
        }
        return array;
    }

    public void replaceOrRemove(List<String> list, String key, String value) {
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (!element.contains(key))
                continue;
            if (value != null && !value.isEmpty()) {
                list.set(i, element.replace(key, value));
            } else {
                list.remove(i);
                i--;
            }

        }
    }

    public void replaceOrRemove(List<String> list, Map<String, String> replaceMap) {
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            boolean found = false;
            String newString = element;
            boolean contains = false;
            for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
                String key = entry.getKey();
                //Есть ли в этой строке вообще плейсхолдеры
                if (!element.contains(key))
                    continue;
                String value = entry.getValue();
                contains = true;
                if (value == null || value.isEmpty()) {
                    newString = newString.replace(entry.getKey(), "");
                    continue;
                }
                //Уже не удаляем
                found = true;
                newString = newString.replace(entry.getKey(), entry.getValue());
            }
            if (!contains)
                continue;
            if (!found) {
                list.remove(i);
                i--;
            } else {
                list.set(i, newString);
            }

        }
    }

}
