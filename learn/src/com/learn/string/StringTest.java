package com.learn.string;

/**
 * @author windyStreet
 * @codetime 2021-03-27 9:38
 *
 *
 * String 的不可变性
 * ==> 对常量池中的数据不可修改，对现有常量池中的字符串的操作都必须新建一个对象
 * String 实际实现为 private final char value[];
 * 常量池
 * 1.6 -> 永久代
 * 1.7 -> 堆
 * 1.8 -> 方法区
 */
public class StringTest {
    String s = "hello";
    char[] cs = {'t', 'e', 's', 't'};

    public void change(String s, char[] cs) {
        s = "world";
        cs[0] = 'b';
        System.out.println(s);
        System.out.println(cs);
    }

    public static void main(String[] args) {
        StringTest st = new StringTest();
        st.change(st.s, st.cs);
        System.out.println(st.s);
        System.out.println(st.cs);
        st.equals("sss");

    }
}
