package com.pwh.jdk.number;

/**
 * @author Waver Pan
 * @date 2022/6/25 3:32
 */
public class Test {
    public static void main(String[] args) {
        //-128到127之间不会封装对象而是用常量池的值，不在这个范围才会创建对象
        Integer a = 888;
        Integer b = 888;
        boolean bool = a == b;
        boolean bool1 = a.equals(b);
        System.out.println(bool+"");
        System.out.println(bool1+"");

        Integer a2 = 8;
        Integer b2 = 8;
        boolean bool2 = a2 == b2;
        boolean bool22 = a2.equals(b2);
        System.out.println(bool2+"");
        System.out.println(bool22+"");
    }
}
