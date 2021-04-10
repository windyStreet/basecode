package com.learn.io.stream;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author windyStreet
 * @codetime 2021-04-09 16:52
 */

/**
 * RandomAccessFile
 * 1、直接继承与Object ，实现了DataInput、DataOutput 接口
 * 2、既可以作为输入流也可以作为输出流
 * 3、如果作为输出流，写出到的文件不存在，则执行过程中自动创建
 * 如果写出到文件存在，则会对原文内容从头开始覆盖
 * mode：
 * r 只读
 * rw 可读可写
 * rwd
 * rws
 */
public class RandomAccessFileTest {

    @Test
    public void testRandomAccessFile() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("code.png"), "r");
            raf2 = new RandomAccessFile(new File("code_RandomAccessFileTest.png"), "rw");

            byte[] buff = new byte[1024];
            int len;
            while ((len = raf1.read(buff)) != -1) {
                raf2.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf2 != null)
                    raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testRandomAccessFile1() {

        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("test1.txt"), "rw");
            raf1.write("111100000000000".getBytes(StandardCharsets.UTF_8));
            raf1.seek(3);
            raf1.write("XXXX".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testInsert(){
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("test2.txt"), "rw");
            raf1.write("abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8));


            raf1.seek(3);
            StringBuilder sb = new StringBuilder((int) new File("test2.txt").length());
            byte[] buff = new byte[20];
            int len;
            while ((len = raf1.read(buff))!= -1 ){
                sb.append(new String(buff,0,len));
            }
            raf1.seek(3);
            // 插入
            raf1.write("XXXX".getBytes());
            // 连接后续数据
            raf1.write(sb.toString().getBytes());;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInsertByteArrayStream(){
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("test3.txt"), "rw");
            raf1.write("abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8));


            raf1.seek(3);
//            StringBuilder sb = new StringBuilder((int) new File("test2.txt").length());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[20];
            int len;
            while ((len = raf1.read(buff))!= -1 ){
                bos.write(buff,0,len);
//                sb.append(new String(buff,0,len));
            }
            raf1.seek(3);
            // 插入
            raf1.write("XXXX".getBytes());
            // 连接后续数据
            raf1.write(bos.toByteArray());;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
