package com.jvm;

public class JVMClassLinking {
    private static int num = 1;

    static {
        num = 3;
        number = 1;
        if (num > 2) {
            System.out.println(num);
        }
//        if (number > 2) {
//            System.out.println("2");
//        }
//        System.out.println(number);
    }

    private static  int number = 10;

    public static void main(String[] args) {
        System.out.println(num);
    }
}
