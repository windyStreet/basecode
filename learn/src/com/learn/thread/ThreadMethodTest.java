package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-23 9:56
 */

/**
 * thread 中的常用方法
 * start() 启动当前线程，调用当前线程的run()
 * run() 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * currentThread() 静态方法，返回执行当前代码的线程
 * getName() 获取当前线程的名字
 * setName() 设置当前线程的名字
 * yield() 释放线程的执行权限
 * join() 在线程a中调用线程b的join(),此时线程a进出入阻塞状态，直到线程b执行结束，线程a结束
 * 阻塞状态继续执行
 * stop() 已过时 当执行此方法时，强制结束当前线程
 * sleep(long millis) 休眠 单位毫秒
 * isAlive() 判断线程是否存活
 * <p>
 * 线程的优先级
 * public final static int MIN_PRIORITY = 1;
 * public final static int NORM_PRIORITY=5;
 * public final static int MAX_PRIORITY=10;
 * 设置、获取当前线程的优先级别
 * setPriority();
 * getPriority();
 * 只是概率高一些，并不进行阻塞
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            System.out.println(getName() + ":" + i);
            try {
                sleep(0);
//                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 20 == 0)
//                yield();
                Thread.yield();
        }
    }

    public HelloThread(String name) {
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
//        HelloThread h1 = new HelloThread();
        HelloThread h1 = new HelloThread("Thread---");
        System.out.println(h1.getName());
        h1.setName("线程一");
        System.out.println(h1.getName());
        h1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(h1.getName() + "优先级是" + h1.getPriority());
        h1.start();
        System.out.println(Thread.currentThread().getName() + "优先级是" + Thread.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 15) {
//                try {
////                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
        System.out.println(h1.isAlive());
    }

}
