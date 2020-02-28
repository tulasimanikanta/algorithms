package com.practice.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinPoolExample {

    public static void main(String[] a) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        var submit = forkJoinPool.submit(
                () -> IntStream.range(1, 100)
                        .filter(i -> {
                            System.out.println(i + " filter " +Thread.currentThread().getName());
                            return i % 2 != 0;
                        })
                        .mapToObj(i -> {
                            System.out.println(i + " mapToObj " +Thread.currentThread().getName());
                            return i + "_";
                        })
                        .parallel()
                        .forEach(task -> updateValues(task + Thread.currentThread().getName()))
        );
        submit.quietlyJoin();

        if (!submit.isCompletedNormally()) {
            System.out.println("submit");
        }
    }

    private static void updateValues(String test) {
        try {

            Thread.sleep(500);
            System.out.println(test);
            throw new NullPointerException("noe");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
