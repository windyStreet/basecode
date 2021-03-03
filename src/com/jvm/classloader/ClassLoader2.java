package com.jvm.classloader;

import sun.awt.windows.ThemeReader;


public class ClassLoader2 {
    public static void main(String[] args) {
        try {
            ClassLoader classLoader1 = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader1); //null

            ClassLoader classloader2 = Thread.currentThread().getContextClassLoader();
            System.out.println(classloader2); //sun.misc.Launcher$AppClassLoader@18b4aac2

            ClassLoader classloader3 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classloader3); //sun.misc.Launcher$ExtClassLoader@1540e19d
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
