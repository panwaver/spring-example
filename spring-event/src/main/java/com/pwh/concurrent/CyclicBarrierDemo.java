package com.pwh.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏
 *CyclicBarrier 一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行
 * @author Waver Pan
 * @date 2022/7/6 16:32
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n);
        CountDownLatch countDownLatch = new CountDownLatch(4);
//        for (int i = 0; i < n; i++)
//            new Writer(barrier).start();
        for (int i = 0; i < n; i++)
            new Writer(barrier,countDownLatch,i).start();
        countDownLatch.await();
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;
        private CountDownLatch countDownLatch;
        private int i;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public Writer(CyclicBarrier cyclicBarrier,CountDownLatch countDownLatch) {
            this.cyclicBarrier = cyclicBarrier;
            this.countDownLatch = countDownLatch;
        }

        public Writer(CyclicBarrier cyclicBarrier,CountDownLatch countDownLatch,int i) {
            this.cyclicBarrier = cyclicBarrier;
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * i); //以睡眠来模拟线程需要预定写入数据操作
                System.out.println(" 线程" + Thread.currentThread().getName() + " 写入数据完毕，等待其他线程写入完毕");
                countDownLatch.countDown();
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }
}
