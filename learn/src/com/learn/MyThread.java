package com.learn;

/**
 * @author windyStreet
 * @codetime 2021-03-22 18:01
 */

/**
 * 多线程创建
 * 1、继承于Thread
 * 2、重写Thread中的Run() --> 将此线程执行的操作定义在run（）中
 * 3、创建Thread类的子类对象
 * 4、通过此对象调用start（）
 */
//继承于Thread
class MyThread extends Thread {
    @Override
    public void run() {
        //重写Thread中的Run() --> 将此线程执行的操作定义在run（）中
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}

