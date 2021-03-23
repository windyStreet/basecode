package com.jvm.stackframe;

public class LocalVariablesTest {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
        test.test10(10, 15);
        staticMethod();
        doubleMethod();
        useDoubleMethod();
        useDoubleMethod1();
    }

    private static void useDoubleMethod() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        //变量c 使用变量b使用完的空间被二次利用
        int c = a + 1;
//        return b + c;
    }
    private static void useDoubleMethod1() {
        int a = 0;
        {
            long b = 0;
            b = a + 1;
        }
        //变量c 使用变量b使用完的空间被二次利用
        int c = a + 1;
//        return b + c;
    }

    private static void doubleMethod() {
        double d = 10.23;
    }

    private static void staticMethod() {
        int a = 0;
    }

    private int test10(int i, int i1) {
        int p = 10;
        int x = p + i + i1;
        return x;
    }


    private void test1() {
        int a = 0;
        String x = "what is ?";
        boolean b = true;
        char c = 'c';
        test2();
    }

    private int test2() {
        long l = (long) 10.00;
        int re = test3();
        return re + (int) l;
    }

    private int test3() {
        int x = 5;
        return x;
    }
}
