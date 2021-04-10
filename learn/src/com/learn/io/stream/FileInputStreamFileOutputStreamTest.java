package com.learn.io.stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author windyStreet
 * @codetime 2021-04-08 16:39
 */

/**
 * 文本文件 用字符流
 * 非文本文件，使用字节流处理
 */
public class FileInputStreamFileOutputStreamTest {

    @Test
    public void testFileInputStream() {

        FileInputStream fileInputStream = null;
        try {
            File file = new File("code.png");
            fileInputStream = new FileInputStream(file);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void copyFile() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File("code.png");
            File destFile = new File("code1.png");
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != fileOutputStream)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void copyFile(String srcPath, String destPath) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != fileOutputStream)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2.mp4";
        String destPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2_1.mp4";
        copyFile(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间:" + (end - start));
    }

}
