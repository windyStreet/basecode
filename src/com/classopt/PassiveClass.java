package com.classopt;


import org.junit.Test;

public class PassiveClass {
    public  void test1(){
        System.out.println(SerialA.ID);
        System.gc();
    }
}

interface SerialA{
    public  static final Thread t = new Thread(){
        {
            System.out.println("SerialA初始化");
        }
    };
    public static final int ID = 1;
}