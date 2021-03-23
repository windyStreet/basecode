package com.jvm.gc;

import java.util.ArrayList;

/**
 *  -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class GCTest {
    byte[] buffer = new byte[1 * 1024 * 1024];//1MB

    public static void main(String[] args) {
        ArrayList<GCTest> list = new ArrayList<>();

        int count = 0;
        try {
            while (true) {
                list.add(new GCTest());
                count++;
            }
        } catch (Throwable e) {
            System.out.println("count = " + count);
            e.printStackTrace();
            System.gc();
        }
    }
}
