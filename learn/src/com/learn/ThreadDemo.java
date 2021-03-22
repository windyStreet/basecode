package com.learn;

/**
 * @author windyStreet
 * @codetime 2021-03-22 17:17
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 3、创建Thread类的子类对象
        MyThread myThread = new MyThread();
        //4、通过此对象调用start（）
        myThread.start();
    }

}
