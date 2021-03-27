package com.learn.string;


import org.junit.Test;

import java.util.Locale;

/**
 * @author windyStreet
 * @codetime 2021-03-27 9:52
 */
public class StringMethodTest {
    @Test
    public void test1() {
        String s = "Hello World";
        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(10));
//        System.out.println(s.charAt(11));
        System.out.println(s.isEmpty());
        String s1 = s.toLowerCase();
        System.out.println(s1);
        System.out.println(s);
        String s2 = s.toUpperCase(Locale.ROOT);
        System.out.println(s2);
        System.out.println(s);
        s.trim();// 去掉两端空格
        System.out.println(s);

    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));

        System.out.println(s3 == s5);

        String s7 = s6.substring(1);
        System.out.println(s7);
        String s8 = s6.substring(2, 3);
        System.out.println(s8);

    }

    @Test
    public void test3() {
        String s1 = "helloAaWorld";
        System.out.println(s1.startsWith("rrr"));
        System.out.println(s1.startsWith("hell"));
        System.out.println(s1.endsWith("d"));
        System.out.println(s1.endsWith("dd"));

        System.out.println(s1.contains("wo"));
        System.out.println(s1.contains("aa"));


        System.out.println(s1.indexOf("o"));
        System.out.println(s1.indexOf("lol"));
        System.out.println(s1.indexOf(97, 3)); // 97
        char x = 97;
        System.out.println(x);
        System.out.println(s1.indexOf("a", 2));
        System.out.println(s1.indexOf("a", 7));
        System.out.println(s1.lastIndexOf("o"));

    }

    @Test
    public void test4() {
        String s1 = "newHelloWorld";
        System.out.println(s1.replace("o", "i"));
        System.out.println(s1.replace("new", "old"));
        String s2 = "12a3b4ddd5ee6teweg78dfaew90";
        System.out.println(s2.replaceAll("\\d+", "|"));
        System.out.println(s2.replaceAll("\\w+", "|")); // 贪心匹配
        System.out.println(s2.replaceFirst("\\d+", "&"));
        System.out.println("-------------------");
        String[] ss = s2.split("d");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }

        System.out.println("-------------------");
        String[] ss1 = s2.split("dd");
        for (int i = 0; i < ss1.length; i++) {
            System.out.println(ss1[i]);
        }

        System.out.println("-------------------");
        String[] ss2 = s2.split("dd");
        for (int i = 0; i < ss2.length; i++) {
            System.out.println(ss2[i]);
        }



    }
}
