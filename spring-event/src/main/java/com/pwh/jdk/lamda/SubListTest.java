package com.pwh.jdk.lamda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panweihua
 * @date: 2020/8/24 19:22
 */
public class SubListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list1 = list.subList(0, 1);
        System.out.println(list.size());
        System.out.println(list1.size());
    }
}
