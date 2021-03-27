package com.learn.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author windyStreet
 * @codetime 2021-03-27 11:20
 */
public class StringTest1 {
    @Test
    public void test() throws UnsupportedEncodingException {
        String s1 = "abc123你好";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] gbkBytes = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbkBytes));

        System.out.println("-------------------------");

        byte[] bytes1 = {};
        String s2 = new String(bytes);
        System.out.println(s2);
        String s3 = new String(gbkBytes);
        System.out.println(s3);
        String s4 = new String(gbkBytes,"gbk");
        System.out.println(s4);

    }
}
