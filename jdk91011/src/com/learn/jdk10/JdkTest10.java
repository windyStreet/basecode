package com.learn.jdk10;

/**
 * @author windyStreet
 * @codetime 2021-04-21 15:10
 */


import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * 局部变量的显示声明--》 局部变量的类型推断
 */
public class JdkTest10 {
    private String name;

    public static void main(String[] args) {
        var num = 10;
        int var = 13;
        var = 16;
        var list = new ArrayList<Integer>();
        list.add(123);
        list.add(124);
        list.add(126);
        for (var x : list) {
            System.out.println(x);
        }

        System.out.println("*****************");
        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("*****************");

        //1、局部变量不赋值就不能实现类型推断
        // var num;

        //2、lambda 表达式中，左边的函数式接口不能声明为var
        Supplier<Double> sup = () -> Math.random();
        Supplier<Double> sup0 = Math::random;
        // var sup1 =()->Math.random();

        // 3、方法引用
        Supplier<Double> sup2 = Math::random;
        //var sup3 = Math::random;
        //var sup3 = System.out::println;

        // 4、数组的静态初始化,如下这种情况也不可以
        int[] arr = {1, 2, 3, 6};
        //var arr ={1,2,3,6};

        // 没有初始化的局部变量声明
        // var s; var m=null;
        // 方法的返回类型

        // 方法的参数类型
        // 构造器的参数类型
        // 属性
        // catch 块

//        try {
//
//        }
//        catch (var e){
//
//        }


    }

    public int method(int x) {
//        int var=10;
//        var x = 15;
        return x;
    }

    // 构造器
//    public JdkTest10(var name) {
//        this.name = name;
//    }

    //方法返回类型
//    public var method(int x){
//        return x;
//    }

    //方法的参数
//    public int  method1(var x){
//        return x;
//    }

    // 属性存在默认值
//    var x=10;
}
