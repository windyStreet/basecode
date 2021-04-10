package com.learn.io.stream;

import org.junit.Test;

import java.io.*;

/**
 * @author windyStreet
 * @codetime 2021-04-08 17:02
 */
public class BufferedTest {


    public void copyFileByFile(String srcPath, String destPath) {

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

    public void copyFileByByBuffered(String srcPath, String destPath) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * 关闭外层流的时候，会自动关闭内层流
             */
            try {
                if (null != bos)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != bis)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void BufferedInputOutputTest() {

        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2.mp4";
        String destPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2_1.mp4";
        copyFileByFile(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("花费时间:" + (end - start));

        start = System.currentTimeMillis();
        srcPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2.mp4";
        destPath = "C:\\Users\\Administrator\\Desktop\\ZGRMFYGYSYZHRMGHGBXFRGWTDJS0_2V2_2.mp4";
        copyFileByByBuffered(srcPath, destPath);
        end = System.currentTimeMillis();
        System.out.println("花费时间:" + (end - start));
    }


    public void copyFileByByBuffer(String srcPath, String destPath) {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(destPath));

//            char[] buf = new char[1024];
//            int len;
//            while ((len = br.read(buf)) != -1) {
//                bw.write(buf, 0, len);
//            }
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();

                // 不包含换行符号
//                bw.write(data+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * 关闭外层流的时候，会自动关闭内层流
             */
            try {
                if (null != bw)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != br)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void encryptionFile(String srcPath, String destPath) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                for (int i = 0; i < buf.length; i++) {
                    buf[i] = (byte) (buf[i] ^ 5);
                }
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

    public void decryptFile(String srcPath, String destPath) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                for (int i = 0; i < buf.length; i++) {
                    buf[i] = (byte) (buf[i] ^ 5);
                }
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


}
