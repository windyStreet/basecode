package com.learn.string;

import org.junit.Test;

/**
 * @author windyStreet
 * @codetime 2021-03-27 11:37
 */
public class StringInterview {
    @Test
    public void test() {
        System.out.println("^^^^^^^^^^^^^^^");
        String a = "abcdef";
        String b = "abc";
        String c = "def";
        final String e = "abc";
        String f = e + c;
        String g = e + "def";
        String h = b + c;
        System.out.println(a == f);
        System.out.println(a == g);
        System.out.println(a == h);

    }
}
