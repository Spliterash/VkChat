package ru.spliterash.vkchat.utils;

import junit.framework.TestCase;
import org.junit.Assert;

public class ArrayUtilsTest extends TestCase {

    public void testPutAll() {
        Integer[] a1 = {1, 2, 3, 4, 5};
        Integer[] a2 = {6, 7, 8, 9};
        Integer[] result = ArrayUtils.putAll(Integer.class, a1, a2, 0);
        Assert.assertArrayEquals(result, new Integer[]{6, 7, 8, 9, 1, 2, 3, 4, 5});
    }
}