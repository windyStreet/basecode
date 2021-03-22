package com.classfile;

public class BaseClassFile {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        System.out.println(a == b); // true

        Integer x = 6;
        Integer y = 6;
        System.out.println(x == y); // true

        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false

        Integer a2 = 7;
        Integer b2 = 7;
        System.out.println(a2 == b2); // true

        String s = new String("hello") + new String("world");
        String s1 = "helloworld";
        System.out.println(s == s1); // false

        String s3 = "AAABBB";
        String s2 = new String("AAA") + new String("BBB");

        System.out.println(s2 == s3); // false


        String s4 = "111222";
        String s5 = new String("111222") ;
        System.out.println(s4 == s5); // true
    }
}
