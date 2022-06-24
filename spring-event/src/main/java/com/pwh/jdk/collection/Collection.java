package com.pwh.jdk.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Waver Pan
 * @date 2022/6/8 20:43
 */
public class Collection {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        List<Object> list1 = Collections.synchronizedList(new ArrayList<>());
        LinkedList<Integer> integers = new LinkedList<>();
        LinkedHashSet<Integer> integers1 = new LinkedHashSet<>();
        HashSet<Object> objects = new HashSet<>();
        int[] array = new int[]{1,2,3};
        List<Object> objects1 = Lists.newArrayList(array);
        //有坑 Arrays#asList 返回的 ArrayList 其实是个李鬼，仅仅只是 Arrays 一个内部类，并非真正的 java.util.ArrayList。
        // add/remove 等方法实际都成自 AbstractList，而 java.util.Arrays$ArrayList 并没有重写父类的方法。而父类方法恰恰都会抛出 UnsupportedOperationException
        List<Object> objects2 = Arrays.asList(array);
    }
}
