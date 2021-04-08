package com.learn.io;

/**
 * @author windyStreet
 * @codetime 2021-04-08 13:51
 */


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、流的分类
 * 1、操作数据单位：字节流、字符流
 * 2、数据流向：输入流 、输出流
 * 3、流的角色： 节点流、处理流
 * 二、流的体系结构
 * 抽象基类                 节点流（文件流）                缓冲流（处理流的一种）
 * InputStream              FileInputStream               BufferedInputStream
 * OutputStream             FileOutputStream              BufferedOutputStream
 * Reader                   FileReader                    BufferedReader
 * Writer                   FileWriter                    BufferedWriter
 */
public class FileReaderWriterTest {

    /**
     * read() 理解 返回读入的一个字符，如果达到文件的末尾，返回-1
     * 异常处理：为了保证流资源一定可以执行关闭操作哦，需要使用 try-catch-finally 处理
     */
    @Test
    public void testFileReader() {

        FileReader fr = null;
        try {
            // 1、 创建一个文件
            File file = new File("fileReaderWriterTest.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            // 2、创建一个FileReader
            fr = new FileReader(file);

            // 3、数据写入
            // read() 返回读入的一个字符，如果达到文件的末尾，返回-1
//        int read = fr.read();
//        while (read != -1)
//        {
//            System.out.println((char) read);
//            read = fr.read();
//        }

            // 语法修改
            int read;
            while ((read = fr.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("fileReaderWriterTest.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fr = new FileReader(file);

            int read;
            char[] char_arr = new char[3];
            StringBuilder sb = new StringBuilder();
            while ((read = fr.read(char_arr)) != -1) {
                sb.append(new String(char_arr, 0, read));
//                for (int i = 0; i < read; i++) {
//                    System.out.print(char_arr[i]);
//                }
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 从内存中写出数据到文件中
     * <p>
     * 说明:
     * 1、输出操作，对应的File可以不存在，并不会报异常
     * 2、
     */
    @Test
    public void testFileWriter() {

        // 1、提供File类的对象，指明写出到的文件

        File file = new File("fileReaderWriterTest.txt");
        FileWriter fileWriter = null;
        try {
            // 提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file, true);
//            fileWriter = new FileWriter(file);
            fileWriter.write("I have a dream!\n");
            fileWriter.write("you need have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
