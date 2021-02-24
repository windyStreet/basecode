package com.interview.bigdata;

import sun.security.util.BitArray;

public class FindTheNumNotExist {
    public static void main(String[] args) {
//        Math.random(10000*10000*40)
        BitArray ba = new BitArray(8 * 1024);
        ba.set(1000, true);
        ba.set(1001, true);
        ba.set(1005, false);

        for (int i = 0; i < 8 * 1024; i++) {
            if (ba.get(i))
                System.out.println(i);
        }

        com.sun.org.apache.xalan.internal.xsltc.dom.BitArray bitArr = new com.sun.org.apache.xalan.internal.xsltc.dom.BitArray();
        bitArr.setBit(1);
        bitArr.setBit(0);
        bitArr.setBit(10);
        bitArr.setBit(11);

        byte[] bitmap = new byte[4];
        bitmap[0] = Byte.parseByte("0");
        bitmap[1] = Byte.parseByte("1");
        bitmap[2] = Byte.parseByte("10");
        bitmap[3] = Byte.parseByte("11");

        for (byte b : bitmap) {
            System.out.println(b);
        }

    }

}
