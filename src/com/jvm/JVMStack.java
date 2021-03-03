package com.jvm;

public class JVMStack {
    private static int count = 1;

    public static void main(String[] args) {
        try {
            // 默认9690
            // 设置-Xss 为 16M  --//160928
            System.out.println(count);
            count++;
            main(args);
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
//        System.out.println(div());

    }

    private static double div() {
        try {
            double x = 3/0;
            return 1.0;
        } catch (Exception e) {
            System.out.println(e);
            return -1.0;
        } finally {
            System.out.println("haha");
        }
    }
}
