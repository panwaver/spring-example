package com.pwh.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 信号量-控制同时访问的线程个数
 * CountDownLatch 和CyclicBarrier 都能够实现线程之间的等待，只不过它们侧重点不
 * 同；CountDownLatch 一般用于某个线程A 等待若干个其他线程执行完任务之后，它才
 * 执行；而CyclicBarrier 一般用于一组线程互相等待至某个状态，然后这一组线程再同时
 * 执行；另外，CountDownLatch 是不能够重用的，而CyclicBarrier 是可以重用的。
 * Semaphore 其实和锁有点类似，它一般用于控制对某组资源的访问权限
 *
 * @author Waver Pan
 * @date 2022/7/6 16:35
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int N = 8; //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for (int i = 0; i < N; i++)
            new Worker(i, semaphore).start();
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}