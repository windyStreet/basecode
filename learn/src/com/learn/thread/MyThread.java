package com.learn.thread;

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
 * 实现 Runnable接口
 * 1、实现Runnable 接口
 * 2、创建一个实现Runnable 接口的类
 * 3、实现Runnable中的抽象方法 run()
 * 4、创建实现类的对象
 * 5、将此对象作为参数传递到Thread类的构造器中，创建Tread类的对象
 * 6、通过Thread类的对象调用start()
 *
 *比较：
 * Thread更合适
 * 1、实现的方式没有类的单继承的局限性
 * 2、实现的方式更适合处理多个线程有共享数据的情况
 */
//继承于Thread
class MyThread extends Thread {
    @Override
    public void run() {
        //重写Thread中的Run() --> 将此线程执行的操作定义在run（）中
        this.commonMethod(Thread.currentThread().getName());
    }

    public void commonMethod(String ThreadName) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0)
                System.out.println(ThreadName + "start ：" + i);
        }
    }
}




