package com.learn.jdk9;

/**
 * @author windyStreet
 * @codetime 2021-04-20 9:23
 */
public class MyInterfaceImpl  implements  MyInterface{
    @Override
    public void methodAbstract() {
        System.out.println("实现类重写抽象方法");
    }

//    @Override
//    public void methodDefault() {
//
//    }

    public static void main(String[] args) {
        // 接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        // 接口的实现类不能调用接口的静态方法
        //MyInterfaceImpl.methodStatic();
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.methodDefault();
        myInterface.methodAbstract();
        // 接口定义的私有方法，不能在接口外部调用
        //myInterface.methodPrivate();
    }
}
