package com.pwh;

/**
 * @author Waver Pan
 * @date 2022/7/7 1:38
 */
public class A {
protected int method1(int a,int b){
    return  0;
}

    public static void main(String[] args) {
        A a = new B();
        int i = a.method1(1, 1);
        System.out.println("value:"+i);
    }
}
class B extends A{
    @Override
     protected int method1(int a, int b) {
        return 1;
    }
}