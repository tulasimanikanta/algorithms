package com.practice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * sync mechanism that waits the one or more threads to wait until work on other thread to complete
 * Compute all of CompletetableFeature is also similar counter part for count down latch
 */
public class CountDownLatchTreadingExample {
    static CountDownLatch latch = new CountDownLatch(4);
    static ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] s) throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName() +
                " has started processing threads using count down latch");
        for(int i = 1 ; i <= 5 ; i++) {
            Worker worker = new Worker(1000*i, latch, "WORKER-" + i);
            executor.submit(worker);
            worker.start();
        }

        latch.await();

        System.out.println(Thread.currentThread().getName() +
                " has finished");
        executor.shutdown();
        System.out.println(Thread.currentThread().getName() +
                " has started processing threads using completable feature");

        List<CompletableTasks> completableTasks = new ArrayList<>();
        for(int i = 1 ; i <= 5 ; i++) {
            completableTasks.add(new CompletableTasks(1000 * i));
        }
        List<CompletableFuture> completableFutures = completableTasks.stream().map( task -> task.task()).collect(Collectors.toList());
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).get();

        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }
}

class CompletableTasks {

    private long delay ;

    CompletableTasks(long delay) {
        this.delay = delay;
    }

    CompletableFuture<Void> task() {

        return CompletableFuture.runAsync( () -> {
            System.out.println("task processing started by " + Thread.currentThread().getName());
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task processing completed by " + Thread.currentThread().getName());
        });
    }
}

class Worker extends Thread
{
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getName()
                    + " processing started");
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName()
                    + " finished");
            latch.countDown();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

