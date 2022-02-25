package com.pwh.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author Waver Pan
 * @date 2022/2/24 16:04
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private long max = 200;

    private long start;
    private long end;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0l;
        if (end - start < max) {
            System.out.println(Thread.currentThread().getName() + ",start:" + start + ",end:" + end);
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 400+1 200 1-200,201-400
            long l = (end + start) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, l);
            left.fork();
            ForkJoinDemo rigt = new ForkJoinDemo(l + 1, end);
            rigt.fork();
            left.join();
            rigt.join();
            try {
                sum = left.get() + rigt.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1l, 400l);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        System.out.println(submit.get());

    }
}
