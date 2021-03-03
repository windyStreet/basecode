package com.base;

import java.io.*;

public class BaseCodeTest {


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("i‘m ".concat(String.valueOf(i)).concat("\n"));
        }
        String str = sb.toString();
        byte[] bt = str.getBytes();
        String fileName = "out.txt";
        try {
            FileOutputStream in = new FileOutputStream(fileName);
            try {
                in.write(bt, 0, bt.length);
                System.out.println("写入文件成功");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
