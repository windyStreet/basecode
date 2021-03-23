package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-22 17:17
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // 3、创建Thread类的子类对象
        MyThread myThread = new MyThread();
        //4、通过此对象调用start（）
        myThread.start();  // 已经start的线程不能再次启动一个线程，需要重新创建一个线程对象
//        myThread.run();// 不能使用run方法启动一个线程
        MyThread myThread_1 = new MyThread();
        myThread_1.start();
        myThread.commonMethod(Thread.currentThread().getName());

        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();
    }

}
