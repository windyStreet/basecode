package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-25 16:22
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、
 * 实现重复利用。
 */

class NumberThread implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (0 == i % 2) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class  CallThread implements Callable {
    @Override
    public synchronized Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(20);
            if (1 == i % 2) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return null;
    }
}


public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1、提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 2、执行指定的线程操作，需要提供一个Runnable 接口或者Callable接口实现类的对象
//        executorService.execute(new NumberThread()); //适合Runnable
//        executorService.execute(new NumberThread()); //适合Runnable
//        executorService.execute(new NumberThread()); //适合Runnable
        executorService.submit(new CallThread());// 适合Callable
        executorService.shutdown(); // 关闭连接池

    }
}
