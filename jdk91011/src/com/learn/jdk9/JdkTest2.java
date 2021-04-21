package com.learn.jdk9;

import java.io.*;

/**
 * @author windyStreet
 * @codetime 2021-04-21 11:31
 */
public class JdkTest2 {

    /**
     * 实现文件复制 传输流
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {

        ClassLoader c1 = JdkTest2.class.getClassLoader();

        File file = new File("cc.txt");
        try (InputStream is = c1.getResourceAsStream("jdk9test.txt"); OutputStream os = new FileOutputStream(file);) {
            is.transferTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
