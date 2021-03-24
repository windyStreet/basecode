package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-23 10:35
 */

// 线程安全
class Window_3 extends Thread {
    private static int ticket = 100;

    @Override
    synchronized public void run() {
        while (true) {
            show();
        }
    }

    // 添加synchronized 使得执行唯一 同步监视器是当前类 Window_3.class
    private static synchronized void show() {
        if (ticket > 0) {
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

public class WindowTicketDemo_3 {
    public static void main(String[] args) {
        Window_3 w1 = new Window_3();
        Window_3 w2 = new Window_3();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w1.start();
        w2.start();


    }

}
