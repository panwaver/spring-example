package com.pwh.jdk.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * @author panweihua
 * @date: 2020/8/25 10:08
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<String>(Arrays.asList("xxx", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz", "yyy", "zzz"));
        List<Integer> result = new CopyOnWriteArrayList();

        System.out.println(Runtime.getRuntime().availableProcessors());

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() << 2);
        forkJoinPool.submit(() -> list.parallelStream().forEach(c -> {
            result.add(c.hashCode());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+"aaaaaaaaaa");
        })).get();

        System.out.println(result.size());
        System.out.println("bbbbbbbbbbbb");
        result.forEach(System.out::println);

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        while (true){
//            System.out.println("bbbbbbbbbbbb");
//        }

    }
}
