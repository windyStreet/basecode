package com.learn.thread;

/**
 * @author windyStreet
 * @codetime 2021-03-23 10:35
 */

// 线程安全
class Window_2 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {
            // 当前类是唯一的
            synchronized (Window_2.class) {
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
}

public class WindowTicketDemo_2 {
    public static void main(String[] args) {
        Window_2 w1 = new Window_2();
        Window_2 w2 = new Window_2();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w1.start();
        w2.start();


    }

}
