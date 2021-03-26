package com.learn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author windyStreet
 * @codetime 2021-03-25 15:10
 */

class TC implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(10);
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (0 == i % 2) {
                System.out.println(Thread.currentThread().getName() + "显示:" + i);
            }
            count += i;

        }
        return count;
    }
}


public class ThreadCallableDemo {
    public static void main(String[] args) {
        TC callable = new TC();
        FutureTask futureTask = new FutureTask(callable);
        FutureTask futureTask1 = new FutureTask(callable);
        new Thread(futureTask).start();
        new Thread(futureTask1).start();
        try {
            Object count = futureTask.get();
            System.out.println("总和为:" + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}


