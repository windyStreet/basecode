package com.learn.jdk9;

/**
 * @author windyStreet
 * @codetime 2021-04-20 9:19
 */
public interface MyInterface {

    // 以下三个方法的权限是公开的
    void methodAbstract();
    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }
    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
        methodPrivate();
    }
    // jdk9 中可以定义私有方法
    private  void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }

}
