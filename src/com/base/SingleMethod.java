package com.base;

// 饿汉式
public class SingleMethod {
    private SingleMethod(){} //构造函数私有化
    private static SingleMethod s = new SingleMethod();
    public static SingleMethod getInstance(){
        return s;
    }
}
