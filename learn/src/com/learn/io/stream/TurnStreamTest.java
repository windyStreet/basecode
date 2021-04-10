package com.learn.io.stream;

/**
 * @author windyStreet
 * @codetime 2021-04-08 17:41
 */

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 转换流
 * InputStreamReader 字符流 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter 字符流 将一个字符的输出流转换为字节的输出流
 * 作用：提供字节流与字符流之间的转换
 * 解码： 字节、字节数组 --》 字符、字符串
 * 编码： 字符、字符串 --》 字节、字节数组
 * 字符集
 */
public class TurnStreamTest {

    @Test
    public void test() {
        InputStreamReader isr = null; // 使用系统默认的字符集
        try {
            FileInputStream fis = new FileInputStream("fileReaderWriterTest.txt");
//        InputStreamReader isr = new InputStreamReader(fis); // 使用系统默认的字符集
            // 参数2 指明字符集，取决于源文件的字符集
            isr = new InputStreamReader(fis, "utf-8");
//            isr = new InputStreamReader(fis, "gbk");
            char[] cbuf = new char[1024];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String s = new String(cbuf, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != isr)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void testTurn()  {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("fileReaderWriterTest.txt"), StandardCharsets.UTF_8);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("fileReaderWriterTest_OutputStreamWriter.txt"), "gbk");

            char[] c_buf = new char[12];
            int len;
            while ((len = inputStreamReader.read(c_buf)) != -1) {
                outputStreamWriter.write(c_buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStreamWriter)
                    outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != inputStreamReader)
                    inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
