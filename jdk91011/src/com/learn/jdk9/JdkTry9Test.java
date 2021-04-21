package com.learn.jdk9;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author windyStreet
 * @codetime 2021-04-20 11:16
 */
public class JdkTry9Test {
    public static void main(String[] args) {
        // 允许在try外部定义需要关闭的资源
        // 多个资源用 ";" 分割
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        InputStreamReader inputStreamReader1 = new InputStreamReader(System.in);

        try (inputStreamReader;inputStreamReader1) {
            char[] chars = new char[20];
            int len;
            if ((len = inputStreamReader.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveBase64(String data, String path, Long name) {
        File file;
        file = new File(path, name + ".txt");

        try (OutputStreamWriter ops = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(ops)) {
            bw.append("data:image/jpg;base64,").append(data);
        } catch (Exception e) {
            System.out.println("存图片异常:" + e.getMessage());
        }
    }
}
