package com.learn.thread.threadlock;

/**
 * @author windyStreet
 * @codetime 2021-03-24 18:13
 */
public class LockDemo {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("1");
                    s2.append("a");
                    synchronized (s2) {
                        s1.append("2");
                        s2.append("b");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("3");
                    s2.append("c");
                    synchronized (s1) {
                        s1.append("4");
                        s2.append("d");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
