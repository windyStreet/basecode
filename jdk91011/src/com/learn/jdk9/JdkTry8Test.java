package com.learn.jdk9;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author windyStreet
 * @codetime 2021-04-20 11:16
 */
public class JdkTry8Test {
    public static void main(String[] args) {

        // 需要关闭的资源必须放到try的小括号中
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
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

}
