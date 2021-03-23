package com.jvm.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader AppClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(AppClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader extClassLoader = AppClassLoader.getParent();
        System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@1540e19d
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader); //null

        // 用户自定义加载器默认继承AppClassLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader); //null



    }
}
