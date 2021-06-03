package com.pwh.jdk.reflect;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author panweihua450
 * @date 2021/6/3 21:07
 */
public class First {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0 ;i < 1000 ; i ++){
            System.out.println(i);
        }
        System.out.println("hello world");

        ArrayList<String> strings = Lists.newArrayList("1", "2", "3", "5");
        strings.forEach(System.out::println);
    }
}
