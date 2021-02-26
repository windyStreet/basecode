package com.jvm;

import java.util.ArrayList;

public class JvmGc {
    byte[] A = new byte[1024 * 10];

    public static void main(String[] args) throws InterruptedException {
        ArrayList<JvmGc> heapTest = new ArrayList<>();
        while (true) {
            heapTest.add(new JvmGc());
            Thread.sleep(10);
        }
    }
}
