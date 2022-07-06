package com.pwh;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Waver Pan
 * @date 2022/7/6 10:43
 */
public class LockSupportTest {
    @Test
    public void park(){
        System.out.println("main start");
        Thread thread = new Thread(() -> {
            System.out.println("thread start");
//            LockSupport.park();
//            LockSupport.park(new String("213"));
            LockSupport.park(this);
            System.out.println("thread end");
        });
        thread.start();
        try {
            System.out.println("main sleep start test park");
            Thread.sleep(100);
            System.out.println("main sleep end test park");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object blocker = LockSupport.getBlocker(thread);
        System.out.printf(blocker+"");
        LockSupport.unpark(thread);
        try {
            System.out.println("main sleep start test unpark");
            Thread.sleep(100);
            System.out.println("main sleep end test unpark");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }

    @Test
    public void parkNanos(){
        System.out.println("start");
        LockSupport.parkNanos(10000000000L);
////        LockSupport.park();
//        LockSupport.park(this);
////        LockSupport.park(new String("123sdf"));
//        LockSupport.unpark(Thread.currentThread());
//        Object blocker = LockSupport.getBlocker(Thread.currentThread());
//        System.out.printf(blocker+"");
        System.out.println("end");
    }
}
