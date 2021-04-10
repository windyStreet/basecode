package com.learn.io.stream;

import org.junit.Test;

import java.io.*;

/**
 * @author windyStreet
 * @codetime 2021-04-09 14:40
 */
public class OtherStreamTest {

    /**
     * 打印流
     */
    @Test
    public void testPrintStream() {

        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");

            printStream = new PrintStream(fileOutputStream, true);

            if (printStream != null) {
                System.setOut(printStream);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
        if (printStream != null)
            printStream.close();

    }

    /**
     * 数据流：
     * DataInputStream DataOutputStream
     * <p>
     * 作用： 用于读取或写出基本数据类的变量或字符串
     */

    @Test
    public void testDataStream() {
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("DataStream.txt"));
            dataOutputStream.writeUTF("张三");
            dataOutputStream.writeInt(13);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
            dataOutputStream.writeUTF("这是简介");
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void testDataInputStream() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream("DataStream.txt"));
            String s = dataInputStream.readUTF();
            int i = dataInputStream.readInt();
            boolean b = dataInputStream.readBoolean();
            String in_str = dataInputStream.readUTF();
            System.out.println("姓名是:" + s);
            System.out.println("年龄是:" + i);
            System.out.println("性别是:" + b);
            System.out.println("简介是:" + in_str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataInputStream != null)
                    dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
