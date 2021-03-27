package com.learn.string;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author windyStreet
 * @codetime 2021-03-27 11:47
 */
public class StringBufferAndStringBuilder {
    @Test
    public void test() {
        String s = new String(); //底层创建了一个长度为16的数组
        StringBuffer sb = new StringBuffer("abc"); // 底层创建了一个长度为abc.length()+16长度的数组
//        sb.setCharAt(0,'A');
        sb.reverse();
        System.out.println(sb);
        sb.length();
        sb.append("sdsssssssssssss");
        HashMap hm = new HashMap(90);
    }
    // 效率 String  StringBuffer StringBuilder
    @Test
    public void test1() {

    }
}
