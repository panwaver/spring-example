package com.pwh.jdk.lamda;

import java.util.HashSet;
import java.util.Set;

/**
 * @author panweihua
 * @date: 2020/8/24 17:52
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add(null);
        set.add(null);

        System.out.println(set.contains(null));
    }
}
