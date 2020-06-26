package ru.spliterash.vkchat.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ComponentUtils {
    public <T> T[] putAll(T[] components, T[] add, int to) {
        int newSize = components.length + add.length;
        //noinspection unchecked
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
}
