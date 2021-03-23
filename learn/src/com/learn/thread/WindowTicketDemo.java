package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-23 10:35
 */

/**
 * 实现Runnable 接口
 * 创建一个实现Runnable 接口的类
 * 实现Runnable中的抽象方法 run()
 * 创建实现类的对象
 * 将此对象作为参数传递到Thread类的构造器中，创建Tread类的对象
 * 通过Thread类的对象调用start()
 */
class Window implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            if (ticket <= 0)
                break;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出票:" + ticket);
            ticket--;
        }
    }
}

public class WindowTicketDemo {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        t1.setName("窗口一");
        Thread t2 = new Thread(w);
        t2.setName("窗口二");
        t1.start();
        t2.start();
    }

}
