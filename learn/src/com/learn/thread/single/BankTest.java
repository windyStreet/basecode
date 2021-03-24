package com.learn.thread.single;

/**
 * @author windyStreet
 * @codetime 2021-03-24 17:34
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    // 多线程情况下，多个线程可能同时操作instance 变量，可能生成多个 instance 实例
//    public synchronized static Bank getInstance() {
//        if (null == instance) {
//            instance = new Bank();
//        }
//        return instance;
//    }

    public static Bank getInstance() {
        // 效率稍差
//        synchronized (Bank.class) {
//            if (null == instance) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        if (null == instance) {
            synchronized (Bank.class) {
                if (null == instance) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}