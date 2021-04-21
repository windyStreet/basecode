package com.learn.jdk9;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author windyStreet
 * @codetime 2021-04-20 11:15
 */
public class JdkTry7Test {
    /**
     * try 的优化
     */
    public static void main(String[] args) {

        //jdk8
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(System.in);
            char[] chars = new char[20];
            int len;
            if ((len = inputStreamReader.read(chars))!= -1){
                String str = new String(chars,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStreamReader){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
